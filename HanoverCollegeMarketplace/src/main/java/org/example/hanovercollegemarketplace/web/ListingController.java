package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.image.ImageService;
import org.example.hanovercollegemarketplace.listing.Listing;
import org.example.hanovercollegemarketplace.listing.ListingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Shows the main listings page and (soon) the new listing form.
 */
@Controller
public class ListingController {

    private static final String LIST_VIEW = "listings/index";
    private static final String NEW_VIEW = "listings/new";

    private final ListingRepository listings;
    private final ImageService images;

    public ListingController(ListingRepository listings,
                             ImageService images) {
        this.listings = listings;
        this.images = images;
    }

    @GetMapping("/listings")
    public String list(
            @RequestParam(name = "q", required = false) String query,
            Model model
    ) {
        List<Listing> results;

        if (query == null || query.isBlank()) {
            results = listings.findAll();
        } else {
            results = listings.findByTitleContainingIgnoreCase(query.trim());
        }

        model.addAttribute("listings", results);
        model.addAttribute("q", query == null ? "" : query.trim());

        return LIST_VIEW;
    }

    @GetMapping("/listings/new")
    public String newListingForm(Model model) {
        model.addAttribute("listing", new Listing());
        return NEW_VIEW;
    }

    @PostMapping("/listings")
    public String createListing(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("contactInfo") String contactInfo,
            @RequestParam("file") MultipartFile file,
            Model model
    ) {
        try {
            // Upload image to Cloudinary
            var result = images.upload(file, "hanover-marketplace");
            String imageUrl = (String) result.get("secure_url");

            // For now we won't tie this to a real logged-in user yet
            var listing = new Listing(
                    title.trim(),
                    description.trim(),
                    imageUrl,
                    contactInfo.trim(),
                    null
            );

            listings.save(listing);

            return "redirect:/listings";

        } catch (Exception e) {
            model.addAttribute("error", "Upload failed: " + e.getMessage());
            return NEW_VIEW;
        }
    }
}
