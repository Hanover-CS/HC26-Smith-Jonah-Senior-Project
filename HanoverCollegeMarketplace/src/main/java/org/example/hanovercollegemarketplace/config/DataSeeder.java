package org.example.hanovercollegemarketplace.config;

import org.example.hanovercollegemarketplace.listing.Listing;
import org.example.hanovercollegemarketplace.listing.ListingRepository;
import org.example.hanovercollegemarketplace.user.User;
import org.example.hanovercollegemarketplace.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Drops in a fake user and some sample listings
 * so the site doesn't look empty in demos.
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository users;
    private final ListingRepository listings;

    public DataSeeder(UserRepository users, ListingRepository listings) {
        this.users = users;
        this.listings = listings;
    }

    @Override
    public void run(String... args) {
        // If we already have data, skip seeding
        if (users.count() > 0 || listings.count() > 0) {
            return;
        }

        // Fake user for demo purposes
        User demoUser = new User(
                "demo@hanover.edu",
                "{noop}password", // we'll replace this with a hash later
                "Demo User"
        );
        demoUser = users.save(demoUser);

        // Some placeholder image URLs (you can swap to real ones later)
        Listing couch = new Listing(
                "Blue couch",
                "Comfy blue couch, slightly used. Perfect for a dorm room.",
                "https://via.placeholder.com/600x400?text=Blue+Couch",
                "demo@hanover.edu",
                demoUser
        );

        Listing textbook = new Listing(
                "CS Textbook",
                "Data Structures & Algorithms book, barely used.",
                "https://via.placeholder.com/600x400?text=CS+Textbook",
                "demo@hanover.edu",
                demoUser
        );

        Listing miniFridge = new Listing(
                "Mini fridge",
                "Mini fridge in good condition, great for snacks.",
                "https://via.placeholder.com/600x400?text=Mini+Fridge",
                "demo@hanover.edu",
                demoUser
        );

        listings.save(couch);
        listings.save(textbook);
        listings.save(miniFridge);
    }
}
