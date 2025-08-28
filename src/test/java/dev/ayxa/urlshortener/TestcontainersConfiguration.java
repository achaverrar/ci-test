package dev.ayxa.urlshortener;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Container
	private static final PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:17.5-alpine");

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> postgresContainer() {
		return postgresContainer;
	}
}
