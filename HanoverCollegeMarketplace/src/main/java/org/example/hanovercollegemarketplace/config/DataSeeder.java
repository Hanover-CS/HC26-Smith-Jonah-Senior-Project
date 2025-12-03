package org.example.hanovercollegemarketplace.config;

import org.example.hanovercollegemarketplace.listing.Listing;
import org.example.hanovercollegemarketplace.listing.ListingRepository;
import org.example.hanovercollegemarketplace.user.User;
import org.example.hanovercollegemarketplace.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Drops in a fake user and some sample listings
 * so the site doesn't look empty in demos.
 */
@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository users;
    private final ListingRepository listings;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository users,
                      ListingRepository listings,
                      PasswordEncoder passwordEncoder) {
        this.users = users;
        this.listings = listings;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (listings.count() > 0) {
            return;
        }

        // Fake user for demo purposes
        User demoUser1 = new User(
                "demo1@hanover.edu",
                passwordEncoder.encode("password"),
                "Demo User1"
        );
        demoUser1 = users.save(demoUser1);

        Listing couch = new Listing(
                "Blue couch",
                "Comfy blue couch, slightly used. Perfect for a dorm room.",
                "https://via.placeholder.com/600x400?text=Blue+Couch",
                "demo@hanover.edu",
                new BigDecimal("75.00"),
                demoUser1
        );

        Listing textbook = new Listing(
                "CS Textbook",
                "Data Structures & Algorithms book, barely used.",
                "https://via.placeholder.com/600x400?text=CS+Textbook",
                "demo@hanover.edu",
                new BigDecimal("45.00"),
                demoUser1
        );

        Listing miniFridge = new Listing(
                "Mini fridge",
                "Mini fridge in good condition, great for snacks.",
                "https://via.placeholder.com/600x400?text=Mini+Fridge",
                "demo@hanover.edu",
                new BigDecimal("120.00"),
                demoUser1
        );

        listings.save(couch);
        listings.save(textbook);
        listings.save(miniFridge);
    }
}
