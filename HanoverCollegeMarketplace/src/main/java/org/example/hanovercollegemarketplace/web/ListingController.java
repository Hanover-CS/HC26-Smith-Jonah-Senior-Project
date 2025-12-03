package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.image.ImageService;
import org.example.hanovercollegemarketplace.listing.Listing;
import org.example.hanovercollegemarketplace.listing.ListingRepository;
import org.example.hanovercollegemarketplace.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

/**
 * Handles listing pages:
 * - all listings
 * - my listings
 * - new listing form + create
 * - delete listing (owner only)
 */
@Controller
public class ListingController {

    private static final String LIST_VIEW = "listings/index";
    private static final String NEW_VIEW = "listings/new";
    private static final String FOLDER = "hanover-marketplace";

    private final ListingRepository listings;
    private final ImageService images;
    private final UserRepository users;

    public ListingController(ListingRepository listings,
                             ImageService images,
                             UserRepository users) {
        this.listings = listings;
        this.images = images;
        this.users = users;
    }

    // All listings, with optional search
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
        model.addAttribute("mine", false);

        return LIST_VIEW;
    }

    // Only the logged-in user's listings
    @GetMapping("/listings/mine")
    public String myListings(Authentication auth, Model model) {
        String email = auth.getName().toLowerCase();
        List<Listing> results = listings.findByOwner_EmailIgnoreCase(email);

        model.addAttribute("listings", results);
        model.addAttribute("q", "");
        model.addAttribute("mine", true);

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
            @RequestParam("price") BigDecimal price,
            @RequestParam("file") MultipartFile file,
            Authentication auth,
            Model model
    ) {
        try {
            // Upload image to Cloudinary
            var result = images.upload(file, FOLDER);
            String imageUrl = (String) result.get("secure_url");

            // Look up the currently logged-in user and set as owner
            String email = auth.getName().toLowerCase();
            var owner = users.findByEmail(email).orElse(null);

            var listing = new Listing(
                    title.trim(),
                    description.trim(),
                    imageUrl,
                    contactInfo.trim(),
                    price,
                    owner
            );

            listings.save(listing);

            return "redirect:/listings";

        } catch (Exception e) {
            model.addAttribute("error", "Upload failed: " + e.getMessage());
            return NEW_VIEW;
        }
    }

    /**
     * Delete a listing owned by the current user.
     * Only listings where owner.email == logged-in email will actually be removed.
     */
    @PostMapping("/listings/{id}/delete")
    public String deleteListing(@PathVariable Long id, Authentication auth) {
        var opt = listings.findById(id);
        if (opt.isPresent() && auth != null) {
            var listing = opt.get();
            var owner = listing.getOwner();
            String email = auth.getName().toLowerCase();

            if (owner != null && owner.getEmail().equalsIgnoreCase(email)) {
                listings.delete(listing);
            }
        }

        // After deleting (or trying), go back to "My listings"
        return "redirect:/listings/mine";
    }
}
