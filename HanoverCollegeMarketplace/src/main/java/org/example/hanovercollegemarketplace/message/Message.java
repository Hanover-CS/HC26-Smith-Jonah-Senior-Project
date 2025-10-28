package org.example.hanovercollegemarketplace.message;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 280)
    private String content;

    @Column(nullable = false, updatable = false)
    private Instant createdAt = Instant.now();

    public Message() {}
    public Message(String content) { this.content = content; }

    public Long getId() { return id; }
    public String getContent() { return content; }
    public Instant getCreatedAt() { return createdAt; }
    public void setContent(String content) { this.content = content; }
}
