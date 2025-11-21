package org.example.hanovercollegemarketplace.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creates a Cloudinary client only when cloudinary.enabled=true.
 * Pulls the URL from application properties or the CLOUDINARY_URL env var.
 */
@Configuration
@ConditionalOnProperty(name = "cloudinary.enabled", havingValue = "true")
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(@Value("${cloudinary.url:}") String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("Cloudinary URL isn't set.");
        }
        return new Cloudinary(url);
    }
}
