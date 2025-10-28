package org.example.hanovercollegemarketplace.web;

import org.example.hanovercollegemarketplace.message.Message;
import org.example.hanovercollegemarketplace.message.MessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final MessageRepository repo;

    public HomeController(MessageRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (repo.count() == 0) repo.save(new Message("Hello, Hanover Marketplace!"));
        model.addAttribute("messages", repo.findAll());
        model.addAttribute("newMessage", new Message());
        return "index";
    }

    @PostMapping("/messages")
    public String create(@ModelAttribute("newMessage") Message form) {
        if (form.getContent() != null && !form.getContent().isBlank()) {
            repo.save(new Message(form.getContent().trim()));
        }
        return "redirect:/";
    }
}
