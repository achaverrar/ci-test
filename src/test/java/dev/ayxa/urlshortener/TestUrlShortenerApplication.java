package dev.ayxa.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Import;

public class TestUrlShortenerApplication {

	public static void main(String[] args) {
		SpringApplication.from(UrlShortenerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
