package org.example.hanovercollegemarketplace;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class HanoverCollegeMarketplaceApplicationTests {

    // Provide a Cloudinary bean just for tests
    @TestConfiguration
    static class TestCloudinaryConfig {
        @Bean
        public Cloudinary cloudinary() {
            // this dummy config won't be used for uploads
            return new Cloudinary("cloudinary://test_key:test_secret@demo");
        }
    }

    @Test
    void contextLoads() {
    }
}
