---
layout: default
title: Run and Verify
---

# 6) Run & Verify

In this section, you’ll build and run your Spring Boot application to confirm that the Cloudinary integration is working properly.  
You’ll learn how to verify your configuration, test the upload functionality, and troubleshoot common startup or connection issues.

---

## 6.1 Build the Project

**Purpose:**  
Before running the app, it’s important to ensure that your Gradle build completes successfully and all dependencies (like Cloudinary) are resolved.

**Steps:**
1. Open your project terminal in IntelliJ or VS Code.
2. Run the following command to clean and rebuild your project:

    ```bash
    ./gradlew clean build
    ```

3. Wait for the build to finish.  
   If the build is successful, you’ll see:
   ```
   BUILD SUCCESSFUL
   ```
   If it fails, check for any missing dependencies or configuration errors (especially around the `CLOUDINARY_URL` variable).

---

## 6.2 Run the Application

**Purpose:**  
This starts the Spring Boot application locally using the configuration you’ve prepared.

**Steps:**
1. From the terminal, run:

    ```bash
    ./gradlew bootRun
    ```

2. Watch the console output.  
   If everything is working, you’ll see something similar to:

   ```
   Tomcat initialized with port 8081
   Started HanoverCollegeMarketplaceApplication ...
   ```

3. Once the app is running, open a web browser and go to:  
   👉 [http://localhost:8081](http://localhost:8081)

---

## 6.3 Test Image Uploads

**Purpose:**  
This confirms that your `ImageController` and `ImageService` are correctly communicating with Cloudinary.

**Steps:**
1. On the homepage, locate the image upload form.
2. Choose an image file from your computer.
3. Click **Upload**.
4. Observe what happens:
   - ✅ **If successful**, you’ll be redirected to the *Upload Success* page and see:
     - The “Image uploaded ✅” message  
     - The secure Cloudinary URL  
     - A preview of the uploaded image  
   - ❌ **If unsuccessful**, you’ll see the *Upload Failed* page with an error message.

**Example success output:**
```
Image uploaded ✅
https://res.cloudinary.com/your_cloud_name/image/upload/v1699999999/example.png
```

**Example failure output:**
```
Upload failed ❌
Set CLOUDINARY_URL or cloudinary.url
```

---

## 6.4 Troubleshooting Common Issues

| Problem | Likely Cause | Fix |
|----------|---------------|-----|
| **“Set CLOUDINARY_URL…”** | Missing or invalid environment variable | Ensure `CLOUDINARY_URL` is set in IntelliJ Run Config |
| **401 Unauthorized** | Incorrect API Key or Secret | Regenerate API keys from the Cloudinary dashboard |
| **Upload fails silently** | File exceeds max upload size | Increase upload limits in `application.properties` |
| **Tomcat shuts down immediately** | Bean initialization failure | Temporarily disable Cloudinary integration (`cloudinary.enabled=false`) |

---

## 6.5 Verify Logs and Cloudinary Dashboard

**Purpose:**  
To ensure your uploads are reaching your Cloudinary account.

**Steps:**
1. Log in to your Cloudinary dashboard.
2. Go to **Media Library**.
3. You should see your uploaded images appear under the folder you specified (for example: `hanover-marketplace`).

---

## 6.6 Summary

By completing this step, you’ve successfully:
- Built and launched your Spring Boot application  
- Verified Cloudinary integration and upload functionality  
- Confirmed that the app communicates securely with your Cloudinary account  

---

**Prev:** [Upload Form & Views](05-upload-form-and-views.md)  
**Next:** [Practice Exercises](07-practice-exercises.md)
