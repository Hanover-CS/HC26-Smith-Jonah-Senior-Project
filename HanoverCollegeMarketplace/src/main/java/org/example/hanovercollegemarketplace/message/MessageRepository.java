package org.example.hanovercollegemarketplace.message;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Basic database access for Message objects.
 * Spring handles everything for us here.
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
}
