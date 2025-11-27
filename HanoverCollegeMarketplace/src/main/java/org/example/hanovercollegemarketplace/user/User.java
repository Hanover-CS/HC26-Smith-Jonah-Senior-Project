package org.example.hanovercollegemarketplace.user;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * Basic app user.
 * For now this is just email + password hash and a display name.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Email doubles as username
    @Column(nullable = false, unique = true, length = 255)
    private String email;

    // Store the hash here later, not the raw password
    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false, length = 100)
    private String displayName;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public User() {
        // JPA needs this
    }

    public User(String email, String passwordHash, String displayName) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
