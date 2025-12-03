package org.example.hanovercollegemarketplace;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Makes sure the app can start using a fake Cloudinary bean.
 */
@SpringBootTest
class HanoverCollegeMarketplaceApplicationTests {

    @TestConfiguration
    static class FakeCloudinaryConfig {
        @Bean
        Cloudinary cloudinary() {
            // Fake credentials so tests don't need secrets
            return new Cloudinary("cloudinary://fake_key:fake_secret@fake_cloud");
        }
    }

    @Test
    void contextLoads() {
        // If context fails, the test fails.
    }
}
