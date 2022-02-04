package rahul.jain.urlshortener;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rahul.jain.urlshortener.domain.ShortUrl;
import rahul.jain.urlshortener.service.UrlShortnerController;

import java.util.List;

@SpringBootTest
class UrlshortenerApplicationTests {

	@Autowired
	private UrlShortnerController shortnerController;

	@Test
	void testCreateDeleteShortUrl() {
		ShortUrl shortUrl = shortnerController.create("https://github.com/happyguyrj/url-shortner");
		Assertions.assertNotNull(shortUrl);
		Assertions.assertNotNull(shortUrl.getShortUrl());
		Assertions.assertEquals(10, shortUrl.getShortUrl().length());
		Assertions.assertEquals(0, shortUrl.getTimesAccessed());
		Assertions.assertNull(shortUrl.getLastAccessed());

		shortnerController.delete(shortUrl.getShortUrl());
	}

	@Test
	void testGetLongUrl() {
		ShortUrl shortUrl = shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main");
		String longUrl = shortnerController.view(shortUrl.getShortUrl());
		Assertions.assertNotNull(longUrl);

		ShortUrl url = shortnerController.viewWithMetaInfo(shortUrl.getShortUrl());
		Assertions.assertNotEquals(0, url.getOriginalUrl().length());
		Assertions.assertEquals(2, url.getTimesAccessed());
		Assertions.assertNotNull(url.getLastAccessed());
	}

	@Test
	void testGetLongUrlRateLimit() {
		ShortUrl shortUrl = shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main");

		for (int i = 0; i<10; i++) {
			shortnerController.view(shortUrl.getShortUrl());
		}
		shortnerController.view(shortUrl.getShortUrl());
	}

	@Test
	void testRecreateShortUrl() {
		ShortUrl shortUrl1 = shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		ShortUrl shortUrl2 = shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		Assertions.assertEquals(shortUrl1, shortUrl2);

		shortnerController.view(shortUrl1.getShortUrl());
		ShortUrl shortUrl3 = shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		Assertions.assertTrue(shortUrl1.equals(shortUrl3));
		Assertions.assertEquals(1, shortUrl3.getTimesAccessed());
	}

	@Test
	void testViewAll() {
		shortnerController.flushCache();
		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		List<ShortUrl> allUrls = shortnerController.viewAll();
		Assertions.assertEquals(1, allUrls.size());

		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/");
		allUrls = shortnerController.viewAllWithMetaInfo();
		Assertions.assertEquals(2, allUrls.size());
	}

	@Test
	void testImportExportFlush() {
		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/README.md");
		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/");
		shortnerController.create("https://github.com/happyguyrj/url-shortner/blob/main/");

		List<ShortUrl> allUrlsBeforeFlush = shortnerController.viewAllWithMetaInfo();
		shortnerController.export("test.txt");
		shortnerController.flushCache();
		shortnerController.importData("test.txt");
		List<ShortUrl> allUrlsAfterFlush = shortnerController.viewAllWithMetaInfo();
		allUrlsAfterFlush.removeAll(allUrlsBeforeFlush);
		Assertions.assertEquals(0, allUrlsAfterFlush.size());
	}
}
