package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.message.Message;
import org.example.hanovercollegemarketplace.message.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Legacy home stuff.
 * Now we just use / as a redirect into the main listings page.
 */
@Controller
public class HomeController {

    private static final String DEFAULT_MSG = "Hello, Hanover Marketplace!";
    private final MessageRepository messages;

    public HomeController(MessageRepository messages) {
        this.messages = messages;
    }

    @GetMapping("/")
    public String root() {
        // Always send root to the listings page
        return "redirect:/listings";
    }

    @GetMapping("/index")
    public String home(Model model) {

        if (messages.count() == 0) {
            messages.save(new Message(DEFAULT_MSG));
        }

        model.addAttribute("messages", messages.findAll());
        model.addAttribute("newMessage", new Message());
        return "index";
    }

    @PostMapping("/messages")
    public String create(@ModelAttribute("newMessage") Message form) {

        if (form.getContent() != null) {
            String trimmed = form.getContent().trim();
            if (!trimmed.isBlank()) {
                messages.save(new Message(trimmed));
            }
        }

        return "redirect:/index";
    }
}
