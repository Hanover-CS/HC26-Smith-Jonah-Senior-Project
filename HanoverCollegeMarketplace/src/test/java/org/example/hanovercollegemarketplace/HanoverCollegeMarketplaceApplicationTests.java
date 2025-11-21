package org.example.hanovercollegemarketplace;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Just checks that the whole Spring Boot app starts up without blowing up.
 */
@SpringBootTest
class HanoverCollegeMarketplaceApplicationTests {

    @TestConfiguration
    static class FakeCloudinary {
        @Bean
        public Cloudinary cloudinary() {
            return new Cloudinary("cloudinary://test_key:test_secret@demo");
        }
    }

    @Test
    void contextLoads() {
        // If this fails, something important broke.
    }
}
