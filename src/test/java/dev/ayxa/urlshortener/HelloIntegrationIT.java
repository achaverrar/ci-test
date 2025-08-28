package dev.ayxa.urlshortener;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = UrlShortenerApplication.class)
@Import(TestcontainersConfiguration.class)
public class HelloIntegrationIT {

    @Test
    void dummyIntegrationTest() {
        // A trivial test to ensure Failsafe runs
        assertThat(1 + 1).isEqualTo(3);
    }
}
