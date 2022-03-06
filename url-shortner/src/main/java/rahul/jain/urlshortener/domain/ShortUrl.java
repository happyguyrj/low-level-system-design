package rahul.jain.urlshortener.domain;

import java.util.Date;
import java.util.Objects;

public class ShortUrl {

    private String shortUrl;
    private String originalUrl;
    private Integer timesAccessed;
    private Date lastAccessed;
    private Integer minutesToExpire;

    public ShortUrl(String shortUrl, String originalUrl, Integer timesAccessed, Date lastAccessed, Integer minutesToExpire) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.timesAccessed = timesAccessed;
        this.lastAccessed = lastAccessed;
        this.minutesToExpire = minutesToExpire;
    }

    public ShortUrl(String shortUrl, String originalUrl, Integer timesAccessed, Date lastAccessed) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.timesAccessed = timesAccessed;
        this.lastAccessed = lastAccessed;
    }

    public ShortUrl(String shortUrl, String originalUrl) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Integer getTimesAccessed() {
        return timesAccessed;
    }

    public void setTimesAccessed(Integer timesAccessed) {
        this.timesAccessed = timesAccessed;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public Integer getMinutesToExpire() {
        return minutesToExpire;
    }

    public void setMinutesToExpire(Integer minutesToExpire) {
        this.minutesToExpire = minutesToExpire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShortUrl shortUrl1 = (ShortUrl) o;
        return Objects.equals(shortUrl, shortUrl1.shortUrl) && Objects.equals(originalUrl, shortUrl1.originalUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortUrl, originalUrl);
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "shortUrl='" + shortUrl + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", timesAccessed=" + timesAccessed +
                ", lastAccessed=" + lastAccessed +
                '}';
    }
}
