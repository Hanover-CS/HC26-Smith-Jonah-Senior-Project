package org.example.hanovercollegemarketplace.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Data access for User objects.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
