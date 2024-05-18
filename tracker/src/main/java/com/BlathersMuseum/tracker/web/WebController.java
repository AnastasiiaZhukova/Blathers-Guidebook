package com.BlathersMuseum.tracker.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.BlathersMuseum.tracker.entity.User;
import com.BlathersMuseum.tracker.dao.UserDAO;
import com.BlathersMuseum.tracker.dao.CollectableDAO;
import com.BlathersMuseum.tracker.entity.Collectable;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

import java.util.List;

@Controller
public class WebController {

    private final UserDAO userDAO;
    private final CollectableDAO collectableDAO;

    @Autowired
    public WebController(UserDAO userDAO, CollectableDAO collectableDAO) {
        this.userDAO = userDAO;
        this.collectableDAO = collectableDAO;
    }

    @GetMapping("/welcome")
    public String index(@RequestParam(value = "error", required = false) String error, Model model){
        if (error != null) {
            model.addAttribute("message", "Invalid username or password!");
        }

        return "index";
    }

    @GetMapping("/homepage")
    public String homepage(Model model) {
        List<Collectable> collectables = collectableDAO.getCollectables();
        model.addAttribute("collectables", collectables);
        return "homepage";
    }
    
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration_page";
    }

    @PostMapping("/register")
    public String userRegistration(@ModelAttribute("user") User user, @RequestParam("inputConfirmPassword") String confirmPassword, Model model) {
        if (user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("message", "One of the fields is empty!");
            return "registration_page";
        }

        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("message", "Passwords do not match!");
            return "registration_page";
        }

        if (userDAO.isUserNameNotUnique(user.getUserName())) {
            model.addAttribute("message", "Username is already taken!");
            return "registration_page";
        }

        userDAO.save(user);

        model.addAttribute("message", "Your registration is successful!");
        return "registration_page";
    }
}
