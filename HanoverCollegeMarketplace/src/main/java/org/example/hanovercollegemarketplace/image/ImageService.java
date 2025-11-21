package org.example.hanovercollegemarketplace.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.Map;

/**
 * Handles the actual Cloudinary upload.
 * Saves the file temporarily, uploads it, and then deletes it.
 */
@Service
public class ImageService {

    private static final String TEMP_PREFIX = "upload-";
    private static final String TYPE = "image";

    private final Cloudinary cloudinary;

    public ImageService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public Map<String, Object> upload(MultipartFile file, String folder) throws Exception {

        File temp = Files
                .createTempFile(TEMP_PREFIX, file.getOriginalFilename())
                .toFile();

        file.transferTo(temp);

        try {
            Map<String, Object> result = cloudinary.uploader().upload(
                    temp,
                    ObjectUtils.asMap(
                            "folder", folder,
                            "resource_type", TYPE
                    )
            );

            return result;

        } finally {
            temp.delete();
        }
    }
}
