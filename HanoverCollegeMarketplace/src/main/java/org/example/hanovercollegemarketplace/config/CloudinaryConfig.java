package org.example.hanovercollegemarketplace.config;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "cloudinary.enabled", havingValue = "true", matchIfMissing = false)
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(@Value("${cloudinary.url:${CLOUDINARY_URL:}}") String url) {
        if (url == null || url.isBlank()) {
            throw new IllegalStateException("Set CLOUDINARY_URL or cloudinary.url");
        }
        return new Cloudinary(url);
    }
}
