package edu.greenjack.web.controller;

import edu.greenjack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import edu.greenjack.service.UsersService;

import java.util.List;

@Controller
@ComponentScan("service")
public class UsersController {
    private static final String REDIRECT_USERS = "redirect:/users";
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(value = "/")
    public String test() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String getUsers() {
        return "users";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute User user) {
        usersService.saveUser(new User(user.getName(), user.getAge()));
        return REDIRECT_USERS;
    }

    @PostMapping("/users/update")
    public String updateUser(@ModelAttribute User user) {
        usersService.updateUser(user);
        return REDIRECT_USERS;
    }

    @PostMapping("/users/delete")
    public String deleteUser(@ModelAttribute User user) {
        usersService.deleteUser(user);
        return REDIRECT_USERS;
    }

    @ModelAttribute("allUsers")
    public List<User> getAllUsers() {
        return usersService.findAll();
    }

}
