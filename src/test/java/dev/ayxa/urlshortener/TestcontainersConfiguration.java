package dev.ayxa.urlshortener;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration(proxyBeanMethods = false)
@Testcontainers
class TestcontainersConfiguration {

	@Container
	@ServiceConnection
	private static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:17.5-alpine");

}
