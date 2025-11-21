package org.example.hanovercollegemarketplace.message;

import jakarta.persistence.*;
import java.time.Instant;

/**
 * This is the basic Message object.
 * It just stores the text someone typed and when they posted it.
 */
@Entity
public class Message {

    // Max length for a message — keeps things short and clean.
    public static final int MAX_LEN = 280;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = MAX_LEN)
    private String content;

    // Automatically stamped when the message gets created
    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Message() {
        // Default constructor for JPA stuff
    }

    public Message(String content) {
        this.content = content;
    }

    public Long getId() { return id; }

    public String getContent() { return content; }

    public Instant getCreatedAt() { return createdAt; }

    public void setContent(String content) {
        this.content = content;
    }
}
