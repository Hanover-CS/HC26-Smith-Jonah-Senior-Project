package org.example.hanovercollegemarketplace.listing;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Data access for listings.
 */
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByTitleContainingIgnoreCase(String titlePart);

    // All listings for a specific owner
    List<Listing> findByOwner_EmailIgnoreCase(String email);
}
