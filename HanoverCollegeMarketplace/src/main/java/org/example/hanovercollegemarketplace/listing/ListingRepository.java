package org.example.hanovercollegemarketplace.listing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Data access for listings.
 */
public interface ListingRepository extends JpaRepository<Listing, Long> {

    // We'll use this later for search
    List<Listing> findByTitleContainingIgnoreCase(String titlePart);
}
