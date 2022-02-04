package rahul.jain.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import rahul.jain.urlshortener.database.CreateDatabase;
import rahul.jain.urlshortener.domain.Constants;
import rahul.jain.urlshortener.domain.ShortUrl;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class UrlshortenerApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		CreateDatabase.createNewDatabase(Constants.DATABASE_NAME);
		SpringApplication.run(UrlshortenerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//Create the database table:
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS short_urls(short_url VARCHAR(20), long_url VARCHAR(200))");

		//Insert a record:
		jdbcTemplate.execute("INSERT INTO short_urls VALUES ('8sZbfHRY4y', 'https://github.com/happyguyrj/url-shortner')");
		List<ShortUrl> urls = jdbcTemplate.query("SELECT * from short_urls", (resultSet, rowNum) -> new ShortUrl(resultSet.getString("short_url"), resultSet.getString("long_url")));
		urls.forEach(System.out::println);
	}


}
