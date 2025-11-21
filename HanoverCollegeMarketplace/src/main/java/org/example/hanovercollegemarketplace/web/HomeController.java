package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.message.Message;
import org.example.hanovercollegemarketplace.message.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles the main homepage.
 * Loads messages, drops in a default welcome message if nothing's there,
 * and lets people submit new ones.
 */
@Controller
public class HomeController {

    private static final String DEFAULT_MSG = "Hello, Hanover Marketplace!";
    private static final String VIEW = "index";
    private static final String GO_HOME = "redirect:/";

    private final MessageRepository messages;

    public HomeController(MessageRepository messages) {
        this.messages = messages;
    }

    @GetMapping("/")
    public String home(Model model) {

        // If it's totally empty, toss in a welcome message
        if (messages.count() == 0) {
            messages.save(new Message(DEFAULT_MSG));
        }

        model.addAttribute("messages", messages.findAll());
        model.addAttribute("newMessage", new Message());
        return VIEW;
    }

    @PostMapping("/messages")
    public String create(@ModelAttribute("newMessage") Message form) {

        if (form.getContent() != null) {
            String trimmed = form.getContent().trim();
            if (!trimmed.isBlank()) {
                messages.save(new Message(trimmed));
            }
        }

        return GO_HOME;
    }
}
