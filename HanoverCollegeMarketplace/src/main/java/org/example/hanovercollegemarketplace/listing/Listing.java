package org.example.hanovercollegemarketplace.listing;

import jakarta.persistence.*;
import org.example.hanovercollegemarketplace.user.User;

import java.time.Instant;

/**
 * One item someone is selling or giving away.
 */
@Entity
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 140)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    // For now just one main image URL
    @Column(length = 500)
    private String imageUrl;

    // How to reach the seller (email, phone, etc.)
    @Column(nullable = false, length = 255)
    private String contactInfo;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    // Later we'll hook this up to the logged-in user
    @ManyToOne(optional = true)
    private User owner;

    public Listing() {
        // JPA
    }

    public Listing(String title,
                   String description,
                   String imageUrl,
                   String contactInfo,
                   User owner) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.contactInfo = contactInfo;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public User getOwner() {
        return owner;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
