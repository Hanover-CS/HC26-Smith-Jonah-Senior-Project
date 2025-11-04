---
layout: default
title: Practice
---

# 7) Practice Exercises

Now that your Cloudinary integration is working, it’s time to expand your understanding by building small, hands-on features that go beyond the tutorial.  
These practice exercises reinforce key Spring Boot, Thymeleaf, and Cloudinary concepts.

---

## 🧠 Objective

You’ll extend the existing application with new functionality that uses your `ImageService`, adds validation, and displays uploaded images in creative ways.  
Each exercise can be completed independently, but they build on what you’ve already learned.

---

## 7.1 Exercise 1 — User-Specific Folders

**Goal:**  
Modify your image upload logic to store files inside folders unique to each user.

**Steps:**
1. Open `src/main/java/org/example/hanovercollegemarketplace/image/ImageService.java`.
2. Update the `upload()` method signature to include a `String username` parameter:
    ```java
    public Map<?, ?> upload(MultipartFile file, String folder, String username) throws Exception {
        File temp = Files.createTempFile("upload-", file.getOriginalFilename()).toFile();
        file.transferTo(temp);
        try {
            return cloudinary.uploader().upload(
                temp,
                ObjectUtils.asMap("folder", folder + "/" + username, "resource_type", "image")
            );
        } finally {
            temp.delete();
        }
    }
    ```
3. Update the controller (`ImageController`) to pass the user’s name when calling the service.  
   For now, you can hard-code a test username like `"studentA"`.
4. Run the app and confirm that Cloudinary now creates subfolders such as:
   ```
   hanover-marketplace/studentA/
   hanover-marketplace/studentB/
   ```

---

## 7.2 Exercise 2 — Thumbnails

**Goal:**  
Display a smaller (thumbnail) version of the uploaded image alongside the full-size version.

**Steps:**
1. In `upload-success.html`, below the main image, add another `<img>` tag for the thumbnail:
    ```html
    <img th:src="${#strings.replace(uploadedUrl, '/upload/', '/upload/c_thumb,w_200/')}"/>
    ```
2. Cloudinary automatically interprets this URL transformation to generate a 200 px-wide thumbnail.
3. Re-upload an image and verify that both the original and the thumbnail appear.



## ✅ Summary

These practice challenges extend the tutorial into real-world use cases and give you hands-on confidence with:
- Cloudinary API usage  
- Spring Boot service structure  
- Thymeleaf integration  

---

**Prev:** [Run & Verify](06-run-and-verify.md)  
**Next:** [Troubleshooting](08-summary.md)
