package edu.greenjack.web.controller;

import edu.greenjack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import edu.greenjack.service.UserService;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@ComponentScan("service")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String test() {
        return "index";
    }

    @GetMapping(value = "/users")
    public String getUsers(Model model) {
        return "users";
    }

    @GetMapping("/add")
    public User addUser() {
        userService.saveUser(new User("name", 100));
        return null;
    }

    @ModelAttribute("allUsers")
    public List<User> getAllUsers() {
//        return userService.findAll();
        return List.of(new User("name1", 1001), new User("name2", 2002));
    }
}
