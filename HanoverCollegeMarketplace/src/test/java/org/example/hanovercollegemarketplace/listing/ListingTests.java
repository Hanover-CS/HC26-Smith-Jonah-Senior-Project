package org.example.hanovercollegemarketplace.listing;

import org.example.hanovercollegemarketplace.user.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simple tests for the Listing model.
 */
class ListingTest {

    @Test
    void defaultPriceIsZero() {
        Listing listing = new Listing(
                "Test", "d", null, "c", (User) null
        );

        assertEquals(0, listing.getPrice().compareTo(BigDecimal.ZERO));
    }

    @Test
    void priceIsSavedCorrectly() {
        BigDecimal p = new BigDecimal("19.99");

        Listing listing = new Listing(
                "Test", "d", null, "c", p, null
        );

        assertEquals(0, listing.getPrice().compareTo(p));
    }
}
