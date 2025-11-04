---
layout: default
title: Upload Form
---

# 5) Upload Form & Views (Thymeleaf)

In this section, you’ll add the controller and views that handle uploading images through your website. You’ll build an upload form, success page, and failure page — all connected to the `ImageService` you created earlier.

---

## 5.1 Create the Image Controller

**File:** `src/main/java/org/example/hanovercollegemarketplace/web/ImageController.java`

**Purpose:**  
This controller receives image uploads from the frontend form, uses the `ImageService` to send them to Cloudinary, and returns a view depending on whether the upload succeeded or failed.

**Steps:**
1. Inside your main project folder, open `src/main/java/org/example/hanovercollegemarketplace/`.
2. Create a new subfolder called `web` (if it doesn’t already exist).
3. Inside `web`, create a file named `ImageController.java`.
4. Paste the following code:

    ```java
    package org.example.hanovercollegemarketplace.web;

    import org.example.hanovercollegemarketplace.image.ImageService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import java.util.Map;

    @Controller
    @RequestMapping("/images")
    public class ImageController {
      private final ImageService imageService;
      public ImageController(ImageService imageService) { this.imageService = imageService; }

      @PostMapping("/upload")
      public String upload(@RequestParam("file") MultipartFile file, Model model) {
        try {
          Map<?, ?> result = imageService.upload(file, "hanover-marketplace");
          model.addAttribute("uploadedUrl", result.get("secure_url"));
          return "upload-success";
        } catch (Exception e) {
          model.addAttribute("error", e.getMessage());
          return "upload-failed";
        }
      }
    }
    ```

**Explanation:**
- The `/images/upload` endpoint handles form submissions.
- On success, it returns the `upload-success` view with the Cloudinary image URL.
- On failure, it returns the `upload-failed` view with an error message.

---

## 5.2 Add the Upload Form to Your Homepage

**File:** `src/main/resources/templates/index.html`

**Purpose:**  
This form allows users to select an image and upload it to your Cloudinary account through the controller you just made.

**Steps:**
1. Open or create the file `src/main/resources/templates/index.html`.
2. Add the following form inside the `<body>` tag where you want the uploader to appear:

    ```html
    <form th:action="@{/images/upload}" method="post" enctype="multipart/form-data" class="d-flex gap-2 my-3">
      <input type="file" name="file" accept="image/*" class="form-control" required />
      <button class="btn btn-primary">Upload</button>
    </form>
    ```

**Explanation:**
- The `th:action` attribute tells Thymeleaf to submit to the `/images/upload` endpoint.
- The `enctype="multipart/form-data"` setting ensures image files can be uploaded.
- The `required` attribute prevents empty submissions.

---

## 5.3 Create the Upload Success Page

**File:** `src/main/resources/templates/upload-success.html`

**Purpose:**  
This page displays when the upload is successful and shows a link and preview of the uploaded image.

**Steps:**
1. Create a new file named `upload-success.html` in `src/main/resources/templates/`.
2. Paste this code:

    ```html
    <!doctype html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
      <meta charset="utf-8">
      <title>Upload success</title>
    </head>
    <body>
      <main class="container">
        <h1>Image uploaded ✅</h1>
        <p><a th:href="${uploadedUrl}" th:text="${uploadedUrl}" target="_blank">Open</a></p>
        <img th:src="${uploadedUrl}" alt="Uploaded image" style="max-width:600px;height:auto;" />
        <p><a href="/" class="btn btn-link">Back</a></p>
      </main>
    </body>
    </html>
    ```

**Explanation:**
- The `${uploadedUrl}` variable is injected by the controller.
- The image tag (`<img th:src="${uploadedUrl}" />`) displays the hosted Cloudinary image.
- The “Back” link returns the user to the main page.

---

## 5.4 Create the Upload Failure Page

**File:** `src/main/resources/templates/upload-failed.html`

**Purpose:**  
This page appears if something goes wrong during the upload (e.g., network issue, invalid credentials, or oversized file).

**Steps:**
1. Create a new file named `upload-failed.html` in `src/main/resources/templates/`.
2. Paste the following code:

    ```html
    <!doctype html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
      <meta charset="utf-8">
      <title>Upload failed</title>
    </head>
    <body>
      <main class="container">
        <h1>Upload failed ❌</h1>
        <p th:text="${error}">An error occurred.</p>
        <p><a href="/" class="btn btn-link">Try again</a></p>
      </main>
    </body>
    </html>
    ```

**Explanation:**
- Displays the error message provided by the controller.
- Gives users a quick option to return and try again.

---

## 5.5 Test the Upload Feature

**To verify functionality:**
1. Rebuild and run your app using:
    ```bash
    ./gradlew bootRun
    ```
2. Navigate to [http://localhost:8081](http://localhost:8081).
3. Upload an image file through the form.
4. On success, you should see:
    - A confirmation message (“Image uploaded ✅”)
    - A working Cloudinary-hosted image link
5. On failure, you’ll see the error message on the failure page.

---

## 5.6 See Also

- **Thymeleaf Forms Documentation**  
  [https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html#creating-forms](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html#creating-forms)

- **Cloudinary Java SDK Upload Reference**  
  [https://cloudinary.com/documentation/java_image_upload#upload](https://cloudinary.com/documentation/java_image_upload#upload)

---

**Next step:** Proceed to [Run & Verify](06-run-and-verify.md)

[Prev: : Wire Spring Boot](04-wire-spring-boot.md) | [Next: Run and Verify](06-run-and-verify.md)