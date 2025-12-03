package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.image.ImageService;
import org.example.hanovercollegemarketplace.listing.Listing;
import org.example.hanovercollegemarketplace.listing.ListingRepository;
import org.example.hanovercollegemarketplace.user.User;
import org.example.hanovercollegemarketplace.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Tests for the listing controller.
 */
@ExtendWith(MockitoExtension.class)
class ListingControllerTest {

    @Mock
    ListingRepository listingRepo;

    @Mock
    ImageService imageService;

    @Mock
    UserRepository userRepo;

    @InjectMocks
    ListingController controller;

    @Test
    void listShowsAllWhenNoSearch() {
        List<Listing> fake = List.of(
                new Listing("One", "d", null, "c", (User) null)
        );
        when(listingRepo.findAll()).thenReturn(fake);

        Model model = new ConcurrentModel();
        String view = controller.list(null, model);

        verify(listingRepo).findAll();
        assertEquals("listings/index", view);
        assertEquals(fake, model.getAttribute("listings"));
    }

    @Test
    void listUsesSearchWhenQueryGiven() {
        List<Listing> fake = List.of(
                new Listing("Couch", "d", null, "c", (User) null)
        );
        when(listingRepo.findByTitleContainingIgnoreCase("couch"))
                .thenReturn(fake);

        Model model = new ConcurrentModel();
        String view = controller.list(" couch ", model);

        verify(listingRepo).findByTitleContainingIgnoreCase("couch");
        assertEquals(fake, model.getAttribute("listings"));
    }

    @Test
    void deleteWorksWhenOwnerMatches() {
        User owner = new User();
        owner.setEmail("me@hanover.edu");

        Listing listing = new Listing("Item", "d", null, "c", owner);
        listing.setOwner(owner);

        when(listingRepo.findById(10L)).thenReturn(Optional.of(listing));

        Authentication auth =
                new UsernamePasswordAuthenticationToken("me@hanover.edu", "pw");

        controller.deleteListing(10L, auth);

        verify(listingRepo).delete(listing);
    }
}
