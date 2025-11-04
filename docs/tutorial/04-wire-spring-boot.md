---
layout: default
title: Setup With Springboot
---

# 4) Wire Cloudinary in Spring Boot

This section walks you through connecting your Spring Boot project to Cloudinary by adding the correct dependency, configuration files, and image upload service. By the end, your project will be able to securely communicate with your Cloudinary account and upload images from within your application.

---

## 4.1 Add the Cloudinary Dependency

**File:** `build.gradle.kts`

**Purpose:**  
This dependency installs the official Cloudinary Java SDK so your Spring Boot project can upload and manage images using Cloudinary’s API.

**Steps:**
1. Open your project in IntelliJ.
2. Locate the file `build.gradle.kts` in your project root directory.
3. Inside the `dependencies { ... }` block, add the following line:

    ```kotlin
    implementation("com.cloudinary:cloudinary-http44:1.37.0")
    ```

4. After saving the file, click the “Load Gradle Changes” popup (or use the Gradle refresh button) to download the dependency.

---

## 4.2 Configure Application Properties

**File:** `src/main/resources/application.properties`

**Purpose:**  
These properties define your server port, enable file upload limits, and connect Spring Boot to Cloudinary through an environment variable. The environment variable `CLOUDINARY_URL` stores your API credentials safely outside of source control.

**Steps:**
1. In your project’s `src/main/resources` directory, open (or create) a file named `application.properties`.
2. Paste the following configuration inside:

    ```properties
    # Server configuration
    server.port=8081

    # Cloudinary connection (reads from environment variable)
    cloudinary.url=${CLOUDINARY_URL:}

    # File upload size limits
    spring.servlet.multipart.max-file-size=10MB
    spring.servlet.multipart.max-request-size=10MB
    ```

3. Save the file.  
   Your app will now pull credentials from the `CLOUDINARY_URL` environment variable you configured earlier in IntelliJ.

---

## 4.3 Add the Cloudinary Configuration Bean

**File:** `src/main/java/org/example/hanovercollegemarketplace/config/CloudinaryConfig.java`

**Purpose:**  
This file creates a Spring-managed `Cloudinary` bean that other parts of your application (like `ImageService`) can automatically use. The configuration ensures Cloudinary initializes only when the correct environment variable is provided.

**Steps:**
1. In IntelliJ, open the folder `src/main/java/org/example/hanovercollegemarketplace/`.
2. Create a new subfolder called `config` if it doesn’t already exist.
3. Inside `config`, create a new Java file named `CloudinaryConfig.java`.
4. Paste the following code:

    ```java
    package org.example.hanovercollegemarketplace.config;

    import com.cloudinary.Cloudinary;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;

    @Configuration
    @ConditionalOnProperty(name = "cloudinary.enabled", havingValue = "true", matchIfMissing = true)
    public class CloudinaryConfig {
      @Bean
      public Cloudinary cloudinary(@Value("${cloudinary.url:${CLOUDINARY_URL:}}") String url) {
        if (url == null || url.isBlank()) {
          throw new IllegalStateException("Set CLOUDINARY_URL or cloudinary.url");
        }
        return new Cloudinary(url);
      }
    }
    ```

**Explanation:**
- The `@Configuration` annotation marks this class as a configuration provider.
- The `@Bean` method registers the `Cloudinary` object with Spring’s application context.
- The `@Value` annotation retrieves your environment variable `CLOUDINARY_URL`.
- The safety check ensures you’ll see a clear error message if the variable isn’t set.

---

## 4.4 Create the Image Upload Service

**File:** `src/main/java/org/example/hanovercollegemarketplace/image/ImageService.java`

**Purpose:**  
This service uses the `Cloudinary` bean created above to handle image uploads from the frontend. It temporarily saves the uploaded file, sends it to Cloudinary, and returns the URL for the uploaded image.

**Steps:**
1. Inside your main project folder `src/main/java/org/example/hanovercollegemarketplace/`, create a new subfolder called `image`.
2. Inside that folder, create a new file named `ImageService.java`.
3. Paste the following code:

    ```java
    package org.example.hanovercollegemarketplace.image;

    import com.cloudinary.Cloudinary;
    import com.cloudinary.utils.ObjectUtils;
    import org.springframework.stereotype.Service;
    import org.springframework.web.multipart.MultipartFile;
    import java.io.File;
    import java.nio.file.Files;
    import java.util.Map;

    @Service
    public class ImageService {
      private final Cloudinary cloudinary;
      public ImageService(Cloudinary cloudinary) { this.cloudinary = cloudinary; }

      public Map<?, ?> upload(MultipartFile file, String folder) throws Exception {
        // Create a temporary file from the uploaded multipart file
        File temp = Files.createTempFile("upload-", file.getOriginalFilename()).toFile();
        file.transferTo(temp);
        try {
          // Upload the file to Cloudinary inside a chosen folder
          return cloudinary.uploader().upload(
            temp,
            ObjectUtils.asMap("folder", folder, "resource_type", "image")
          );
        } finally {
          // Clean up the temporary file after upload
          temp.delete();
        }
      }
    }
    ```

**Explanation:**
- `MultipartFile` represents the uploaded file from the form.
- A temporary file is created for upload safety.
- `cloudinary.uploader().upload()` sends the file to Cloudinary’s servers.
- The result includes the hosted image’s secure URL (`secure_url`) that can be displayed in your views.

---

## 4.5 Verify Your Setup

**To test:**
1. Rebuild your project using the Gradle tool window or by running:

    ```bash
    ./gradlew clean build
    ```

2. Run your app:

    ```bash
    ./gradlew bootRun
    ```

3. Watch the console output.  
   If Cloudinary is correctly configured, the app should start without error.  
   If you see “Set CLOUDINARY_URL or cloudinary.url”, recheck your IntelliJ run configuration.

---

## 4.6 See Also

- **Cloudinary Java SDK → Upload Documentation**  
  [https://cloudinary.com/documentation/java_image_upload#upload](https://cloudinary.com/documentation/java_image_upload#upload)

- **Spring Boot External Config (Official Docs)**  
  [https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config](https://docs.spring.io/spring-boot/reference/features/external-config.html#features.external-config)

---

**Next step:** Proceed to [Upload form & views (Thymeleaf)](05-upload-form-and-views.md)

[Prev: Setup Cloudinary Account](03-setup-cloudinary-account.md) | [Next: Upload Form](05-upload-form-and-views.md)