package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.image.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Handles image uploads.
 * Sends the file over to ImageService and picks the right "success" or "fail" page.
 */

@Controller
public class ImageController {
    private final ImageService images;
    public ImageController(ImageService images) { this.images = images; }

    @PostMapping("/images/upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        try {
            Map<?, ?> res = images.upload(file, "hanover-marketplace");
            model.addAttribute("uploadedUrl", (String) res.get("secure_url"));
            return "upload-success";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "upload-failed";
        }
    }
}
