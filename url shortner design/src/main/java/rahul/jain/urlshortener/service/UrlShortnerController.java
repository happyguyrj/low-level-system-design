package rahul.jain.urlshortener.service;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rahul.jain.urlshortener.domain.Constants;
import rahul.jain.urlshortener.domain.ShortUrl;

import java.io.*;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class UrlShortnerController {

    private HashMap<String, ShortUrl> shortUrltoUrlMetaMap = new HashMap<>();

    private static final Gson gson = new Gson();


    private final int RATE_LIMIT = 10;
    Queue<Date> urlAccessed = new PriorityQueue<>();

        @GetMapping("/createWithExpiry")
    public ShortUrl createWithExpiry(@RequestParam(value = "url") String longUrl,
                                     @RequestParam(value = "minsToExpire") int minsToExpire) {
        ShortUrl url = create(longUrl);
        shortUrltoUrlMetaMap.get(url.getShortUrl()).setMinutesToExpire(minsToExpire);
        return shortUrltoUrlMetaMap.get(url.getShortUrl());
    }

    @Scheduled(cron = "* * * * * 0")
    public void deleteExpiredUrls() {
        shortUrltoUrlMetaMap.keySet()
                .forEach(e -> {
                    int minsToExpire = shortUrltoUrlMetaMap.get(e).getMinutesToExpire();
                    if(minsToExpire == 0) {
                        shortUrltoUrlMetaMap.remove(e);
                    }
                    shortUrltoUrlMetaMap.get(e).setMinutesToExpire(minsToExpire-1);
                });
    }

    @GetMapping("/create")
    public ShortUrl create(@RequestParam(value = "url") String longUrl) {
        MessageDigest md5instance;
        try {
            md5instance = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Cannot create find MD5 sum" + e);
            return null;
        }
        byte[] md5Url = md5instance.digest(longUrl.getBytes(StandardCharsets.UTF_8));
        String encodedUrl = Base64.encodeBase64String(md5Url);

        String shortUrl = "";
        for (int i = 0; i < encodedUrl.length(); i++) {
            if (Character.isLetterOrDigit(encodedUrl.charAt(i)))
                shortUrl = shortUrl.concat(String.valueOf(encodedUrl.charAt(i)));

            if (shortUrl.length() == 10) {
                if (shortUrltoUrlMetaMap.containsKey(shortUrl)) {
                    if (shortUrltoUrlMetaMap.get(shortUrl).getOriginalUrl().equals(longUrl))
                        return shortUrltoUrlMetaMap.get(shortUrl);
                    shortUrl = shortUrl.substring(1);
                }
                else
                    break;
            }
        }

        ShortUrl shortUrlMetaInfo = new ShortUrl(shortUrl, longUrl, 0, null);
        shortUrltoUrlMetaMap.put(shortUrl, shortUrlMetaInfo);

        // todo: enable periodic export to save latest metadata in persistent file, this does not capture access metadata
        writeDataToFile(Collections.singletonList(shortUrlMetaInfo), Constants.FILE_LOCATION + Constants.DEFAULT_FILE_NAME, true);
        return shortUrlMetaInfo;
    }

    @GetMapping("/redirect")
    public ResponseEntity<Void> redirect(@RequestParam(value = "url") String shortUrl) {
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(shortUrltoUrlMetaMap.get(shortUrl).getOriginalUrl())).build();
    }

    @GetMapping("/view")
    public String view(@RequestParam(value = "url") String shortUrl) {
        if (urlAccessed.size() > 10) {
            Date earliestAccessTime = urlAccessed.peek();
            if ((earliestAccessTime.getTime() - new Date().getTime())/(1000*60) > 10) {
                urlAccessed.remove(earliestAccessTime);
                urlAccessed.add(new Date());
            }
            else
                throw new IllegalArgumentException("Rate limited");
        }
        ShortUrl urlMetaInfo = shortUrltoUrlMetaMap.get(shortUrl);
        shortUrltoUrlMetaMap.put(shortUrl, new ShortUrl(shortUrl, urlMetaInfo.getOriginalUrl(),
                urlMetaInfo.getTimesAccessed()+1, new Date()));

        urlAccessed.add(new Date());
        return shortUrltoUrlMetaMap.get(shortUrl).getOriginalUrl();
    }


    @GetMapping("/viewWithMetaInfo")
    public ShortUrl viewWithMetaInfo(@RequestParam(value = "url") String shortUrl) {
        ShortUrl urlMetaInfo = shortUrltoUrlMetaMap.get(shortUrl);
        shortUrltoUrlMetaMap.put(shortUrl, new ShortUrl(shortUrl, urlMetaInfo.getOriginalUrl(),
                urlMetaInfo.getTimesAccessed()+1, new Date()));
        return shortUrltoUrlMetaMap.get(shortUrl);
    }

    @GetMapping("/delete")
    public void delete(@RequestParam(value = "url") String shortUrl) {
        shortUrltoUrlMetaMap.remove(shortUrl);
    }

    @GetMapping("/viewAll")
    public List<ShortUrl> viewAll() {
        return shortUrltoUrlMetaMap.keySet()
                .stream()
                .map(url -> new ShortUrl(url, shortUrltoUrlMetaMap.get(url).getOriginalUrl()))
                .collect(Collectors.toList());
    }

    @GetMapping("/viewAllWithMetaInfo")
    public List<ShortUrl> viewAllWithMetaInfo() {
        return new ArrayList<>(shortUrltoUrlMetaMap.values());
    }

    @GetMapping("/export")
    public void export(@RequestParam(value = "filename", defaultValue = "export.txt") String filename) {
        writeDataToFile(viewAllWithMetaInfo(), Constants.FILE_LOCATION + filename, false);
    }

    @GetMapping("/importData")
    public void importData(@RequestParam(value = "filename", defaultValue = "export.txt") String filename) {
        readFromFile(filename);
    }

    private void writeDataToFile(List<ShortUrl> shortUrls, String location, boolean appendMode) {
        File shortUrlsFile = new File(location);
        if (!shortUrlsFile.exists()) {
            try {
                File directory = new File(shortUrlsFile.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                shortUrlsFile.createNewFile();
            } catch (IOException e) {
                System.out.println("Error in creating file" + e);
            }
        }

        try {
            FileWriter writer;
            writer = new FileWriter(shortUrlsFile.getAbsoluteFile(), appendMode);
            BufferedWriter bufferWriter = new BufferedWriter(writer);

            Gson gson = new Gson();
            bufferWriter.write(gson.toJson(shortUrls));
            bufferWriter.close();
        } catch (IOException e) {
            System.out.println("Error in exporting to file" + e);
        }
    }

    private void readFromFile(String filename) {
        File shortUrlsFile = new File(Constants.FILE_LOCATION + filename);

        if (!shortUrlsFile.exists())
            return;

        InputStreamReader reader;
        try {
            reader = new InputStreamReader(new FileInputStream(shortUrlsFile), StandardCharsets.UTF_8);
            JsonReader myReader = new JsonReader(reader);
            ShortUrl[] shortUrl = gson.fromJson(myReader, ShortUrl[].class);

            List<ShortUrl> shortUrls = Arrays.asList(shortUrl);
            shortUrls.forEach(url -> shortUrltoUrlMetaMap.putIfAbsent(url.getShortUrl(), url));

        } catch (Exception e) {
            System.out.println("Error in importing from file" + e);
        }
    }

    @GetMapping("/flushCache")
    public void flushCache() {
        shortUrltoUrlMetaMap.clear();
    }
}
