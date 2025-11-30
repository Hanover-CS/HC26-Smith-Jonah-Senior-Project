package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.user.User;
import org.example.hanovercollegemarketplace.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles login + sign up screens.
 */
@Controller
public class AuthController {

    private final UserRepository users;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository users, PasswordEncoder passwordEncoder) {
        this.users = users;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        // Spring Security will handle the actual POST login
        return "auth/login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        return "auth/register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("email") String email,
            @RequestParam("displayName") String displayName,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            Model model
    ) {
        email = email.trim().toLowerCase();
        displayName = displayName.trim();

        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords don't match.");
            return "auth/register";
        }

        if (users.findByEmail(email).isPresent()) {
            model.addAttribute("error", "That email is already registered.");
            return "auth/register";
        }

        String hash = passwordEncoder.encode(password);

        User user = new User(email, hash, displayName);
        users.save(user);

        // after sign up, send them to login page
        return "redirect:/login?registered";
    }
}
