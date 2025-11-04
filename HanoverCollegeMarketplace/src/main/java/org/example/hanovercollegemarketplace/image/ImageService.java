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
        File temp = Files.createTempFile("upload-", file.getOriginalFilename()).toFile();
        file.transferTo(temp);
        try {
            return cloudinary.uploader().upload(
                    temp,
                    ObjectUtils.asMap("folder", folder, "resource_type", "image")
            );
        } finally {
            temp.delete();
        }
    }
}
