package org.example.hanovercollegemarketplace.security;

import com.cloudinary.Cloudinary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Checks that /listings requires login.
 */
@SpringBootTest
@AutoConfigureMockMvc
class SecurityFlowTest {

    @Autowired
    MockMvc mockMvc;

    @TestConfiguration
    static class FakeCloudinaryConfig {
        @Bean
        Cloudinary cloudinary() {
            return new Cloudinary("cloudinary://fake_key:fake_secret@fake_cloud");
        }
    }

    @Test
    void listingsRedirectsToLoginWhenLoggedOut() throws Exception {
        mockMvc.perform(get("/listings"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }
}
