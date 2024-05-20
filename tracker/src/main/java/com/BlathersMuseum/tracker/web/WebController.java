package com.BlathersMuseum.tracker.web;

import com.BlathersMuseum.tracker.entity.*;
import com.BlathersMuseum.tracker.service.CollectionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.BlathersMuseum.tracker.dao.UserDAO;
import com.BlathersMuseum.tracker.dao.RoleDAO;
import com.BlathersMuseum.tracker.dao.UsersRolesDAO;
import org.springframework.ui.Model;
import com.BlathersMuseum.tracker.dao.AppliedUsersDAO;
import com.BlathersMuseum.tracker.dao.CollectableFishDAO;
import com.BlathersMuseum.tracker.dao.UserCollectableFishDAO;
import com.BlathersMuseum.tracker.dao.CollectableBugDAO;
import com.BlathersMuseum.tracker.dao.UserCollectableBugDAO;
import com.BlathersMuseum.tracker.dao.CollectableSeaCreatureDAO;
import com.BlathersMuseum.tracker.dao.UserCollectableSeaCreatureDAO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.List;
import java.util.Map;
import com.BlathersMuseum.tracker.service.CollectionService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.BlathersMuseum.tracker.entity.CollectableBug;
import com.BlathersMuseum.tracker.entity.CollectableFish;
import com.BlathersMuseum.tracker.entity.CollectableSeaCreature;
import org.springframework.dao.EmptyResultDataAccessException;


// controller for the endpoints and the logic of the app
@Controller
public class WebController {

    //declaring DAO and services
    private  UserDAO userDAO;
    private RoleDAO roleDAO;
    private UsersRolesDAO usersRolesDAO;
    private AppliedUsersDAO appliedUsersDAO;

    private CollectableFishDAO collectableFishDAO;
    private UserCollectableFishDAO userCollectableFishDAO;

    private CollectableBugDAO collectableBugDAO;
    private UserCollectableBugDAO userCollectableBugDAO;

    private CollectableSeaCreatureDAO collectableSeaCreatureDAO;
    private UserCollectableSeaCreatureDAO userCollectableSeaCreatureDAO;

    private CollectionService collectionService;


    //methods to check user roles
    //get the authentication object and check if the user is an admin /moderator
    public boolean isUserModerator(Authentication authentication) {
        String username = authentication.getName();
        User user = userDAO.searchByUserName(username);
        Role userRole = user.getRole();
        return userRole.getRoleName().equals("moderator");
    }

    public boolean isUserAdmin(Authentication authentication) {
        String username = authentication.getName();
        User user = userDAO.searchByUserName(username);
        Role userRole = user.getRole();
        return userRole.getRoleName().equals("admin");
    }

    //web controller constructor
    @Autowired
    public WebController(UserDAO userDAO, RoleDAO roleDAO, UsersRolesDAO usersRolesDAO, AppliedUsersDAO appliedUsersDAO,
                         CollectionService collectionService, CollectableFishDAO collectableFishDAO, UserCollectableFishDAO userCollectableFishDAO, CollectableBugDAO collectableBugDAO, UserCollectableBugDAO userCollectableBugDAO, CollectableSeaCreatureDAO collectableSeaCreatureDAO, UserCollectableSeaCreatureDAO userCollectableSeaCreatureDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
        this.usersRolesDAO = usersRolesDAO;
        this.appliedUsersDAO = appliedUsersDAO;

        this.collectableFishDAO = collectableFishDAO;
        this.userCollectableFishDAO = userCollectableFishDAO;

        this.collectableBugDAO = collectableBugDAO;
        this.userCollectableBugDAO = userCollectableBugDAO;

        this.collectableSeaCreatureDAO = collectableSeaCreatureDAO;
        this.userCollectableSeaCreatureDAO = userCollectableSeaCreatureDAO;

        this.collectionService = collectionService;
    }

    //checks if the user entered the wrong username or password
    @GetMapping("/welcome")
    public String index(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("message", "Invalid username or password!");
        }

        return "index";
    }

    @GetMapping("/homepage")
    public String homepage(Model model) {

        //getting the username of the user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userDAO.searchByUserName(username);

        //getting user colllections
        List<UserCollectableFish> userFishes = userCollectableFishDAO.getUserCollectableList(user.getUserId());
        List<UserCollectableBug> userBugs = userCollectableBugDAO.getUserCollectableList(user.getUserId());
        List<UserCollectableSeaCreature> userSeaCreatures = userCollectableSeaCreatureDAO.getUserCollectableList(user.getUserId());

        //adding collections to the model
        model.addAttribute("userFishes", userFishes);
        model.addAttribute("userBugs", userBugs);
        model.addAttribute("userSeaCreatures", userSeaCreatures);

        return "homepage";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication authentication) {

        //getting username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userDAO.searchByUserName(username);

        //getting user id
        model.addAttribute("user", user);
        int userId = user.getUserId();

        //getting user collection progress, adding it to the model
        int totalCollectionPercentage = collectionService.calculateTotalCollectionPercentage(userId);
        model.addAttribute("totalCollectionPercentage", totalCollectionPercentage);

        //adding user roles to the model
        model.addAttribute("isModerator", isUserModerator(authentication));
        model.addAttribute("isAdmin", isUserAdmin(authentication));

        //getting and adding applied users to the model
        List<AppliedUsers> appliedUsers = appliedUsersDAO.getAllAppliedUsers();
        model.addAttribute("appliedUsers", appliedUsers);

        return "profile";
    }

    @GetMapping("/register")
    public String registrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration_page";
    }

    //registration logic
    @PostMapping("/register")
    public String userRegistration(@ModelAttribute("user") User user, @RequestParam("inputConfirmPassword") String confirmPassword, Model model) {

        //checks if there are ane empty fields
        if (user.getUserName().isEmpty() || user.getPassword().isEmpty()) {
            model.addAttribute("message", "One of the fields is empty!");
            return "registration_page";
        }

        //checking if password and confirm password are the same
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("message", "Passwords do not match!");
            return "registration_page";
        }

        //rules on the username/password
        if (user.getUserName().length() < 5 || user.getUserName().length() > 50) {
            model.addAttribute("message", "Username should be between 5 and 50 characters!");
            return "registration_page";
        }

        if (!user.getUserName().matches("^[a-zA-Z0-9_]*$")) {
            model.addAttribute("message", "Username can only contain letters, numbers, and underscores!");
            return "registration_page";
        }

        if (user.getPassword().length() < 5 || user.getUserName().length() > 50) {
            model.addAttribute("message", "Username should be between 5 and 50 characters!");
            return "registration_page";
        }

        if (!user.getPassword().matches("^[a-zA-Z0-9_]*$")) {
            model.addAttribute("message", "Username can only contain letters, numbers, and underscores!");
            return "registration_page";
        }

        //checks if username is unique
        if (userDAO.isUserNameNotUnique(user.getUserName())) {
            model.addAttribute("message", "Username is already taken!");
            return "registration_page";
        }

        //while registering user gets the defaul role - user
        Role defaultRole = roleDAO.searchByRoleName("user");
        user.setRole(defaultRole);
        userDAO.save(user);

        //message for th expression
        model.addAttribute("message", "Your registration is successful!");

        return "registration_page";
    }

    //updating the DB collectable tables for each user
    @PostMapping("/update")
    @ResponseBody
    public String updateCollectableStatus(@RequestBody Map<String, Object> payload) {

        //getting username
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userDAO.searchByUserName(username);

        //getting data about collectable
        int collectableId = (Integer) payload.get("collectableId");
        boolean isCollected = (Boolean) payload.get("isCollected");
        String collectableType = (String) payload.get("collectableType");

        //on scheckbox change updating isCollected (true/false) for all three tables
        switch (collectableType) {

            case "fish":
                UserCollectableFish userCollectableFish = userCollectableFishDAO.getUserCollectable(user.getUserId(), collectableId);
                if (userCollectableFish != null) {
                    userCollectableFish.setIsCollected(isCollected);
                    userCollectableFishDAO.saveUserCollectable(userCollectableFish);

                }
                break;
            case "bug":
                UserCollectableBug userCollectableBug = userCollectableBugDAO.getUserCollectable(user.getUserId(), collectableId);
                if (userCollectableBug != null) {
                    userCollectableBug.setIsCollected(isCollected);
                    userCollectableBugDAO.saveUserCollectable(userCollectableBug);
                }
                break;
            case "seaCreature":
                UserCollectableSeaCreature userCollectableSeaCreature = userCollectableSeaCreatureDAO.getUserCollectable(user.getUserId(), collectableId);
                if (userCollectableSeaCreature != null) {
                    userCollectableSeaCreature.setIsCollected(isCollected);
                    userCollectableSeaCreatureDAO.saveUserCollectable(userCollectableSeaCreature);
                }
                break;
            default:
                return "homepage";
        }

        return "homepage";
    }

    //logic for applying to be a moderator
    @PostMapping("/modApply")
    public String applyToBeModerator(Authentication authentication, Model model, RedirectAttributes redirectAttributes) {

        //getting username
        String username = authentication.getName();
        User user = userDAO.searchByUserName(username);

        //checking if user is moderator/admin
        if (user != null) {
            AppliedUsers appliedUser = appliedUsersDAO.searchByUserName(username);
            if (appliedUser == null) {
                appliedUsersDAO.save(new AppliedUsers(username));
            } else {
                //else success
                //message for th expression
                redirectAttributes.addFlashAttribute("message", "You already applied!");
                return "redirect:/profile";
            }
        }

        return "redirect:/profile";
    }

    //logic for changing user role
    @PostMapping("/appointMod")
    public String changeRole(@RequestParam("userName") String userName, Authentication authentication) {
        User user = userDAO.searchByUserName(userName);
        String currentUserName = authentication.getName();

        //checking if the user is not the admin
        if (!currentUserName.equals(userName)) {
            //if user  exists
            if (user != null) {
                Role moderatorRole = roleDAO.searchByRoleName("moderator");
                user.setRole(moderatorRole);
                userDAO.save(user);
            }
        }
        return "redirect:/profile";
    }

    //lodic for moderator update DB
    @PostMapping("/updateBug")
    public String updateBug(@RequestParam("bugName") String bugName, CollectableBug bug, RedirectAttributes redirectAttributes) {

        //catching errors
        try {
            //geting bug by name and using update method
            CollectableBug existingBug = collectableBugDAO.getCollectableByName(bugName);

            if (existingBug != null) {
                existingBug.setName(bug.getName());
                existingBug.setType(bug.getType());
                existingBug.setLocation(bug.getLocation());
                existingBug.setTime(bug.getTime());
                existingBug.setMonths(bug.getMonths());

                collectableBugDAO.updateCollectable(existingBug);
            } else {
                //message for th expression
                redirectAttributes.addFlashAttribute("error", "Collectable not found!");
            }
        } catch (EmptyResultDataAccessException e) {
            //message for th expression
            redirectAttributes.addFlashAttribute("error", "Collectable not found!");
        }
        return "redirect:/profile";
    }

    //logic for moderator to update DB
    @PostMapping("/updateFish")
    public String updateFish(@RequestParam("fishName") String fishName, CollectableFish fish, RedirectAttributes redirectAttributes) {
        try {
            CollectableFish existingFish = collectableFishDAO.getCollectableByName(fishName);

            if (existingFish != null) {
                existingFish.setName(fish.getName());
                existingFish.setType(fish.getType());
                existingFish.setLocation(fish.getLocation());
                existingFish.setTime(fish.getTime());
                existingFish.setMonths(fish.getMonths());

                collectableFishDAO.updateCollectable(existingFish);
            } else {
                //message for th expression
                redirectAttributes.addFlashAttribute("error", "Collectable not found!");
            }
        } catch (EmptyResultDataAccessException e) {
            //message for th expression
            redirectAttributes.addFlashAttribute("error", "Collectable not found!");
        }
        return "redirect:/profile";
    }

    //lodic for moderator to update DB
    @PostMapping("/updateSeaCreature")
    public String updateSeaCreature(@RequestParam("seaCreatureName") String seaCreatureName, CollectableSeaCreature seaCreature, RedirectAttributes redirectAttributes) {
        try {
            CollectableSeaCreature existingSeaCreature = collectableSeaCreatureDAO.getCollectableByName(seaCreatureName);

            if (existingSeaCreature != null) {
                existingSeaCreature.setName(seaCreature.getName());
                existingSeaCreature.setType(seaCreature.getType());
                existingSeaCreature.setLocation(seaCreature.getLocation());
                existingSeaCreature.setTime(seaCreature.getTime());
                existingSeaCreature.setMonths(seaCreature.getMonths());

                collectableSeaCreatureDAO.updateCollectable(existingSeaCreature);
            } else {
                //message for th expression
                redirectAttributes.addFlashAttribute("error", "Collectable creature not found!");
            }
        } catch (EmptyResultDataAccessException e) {
            //message for th expression
            redirectAttributes.addFlashAttribute("error", "Collectable creature not found!");
        }
        return "redirect:/profile";
    }
}
