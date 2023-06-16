package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.UserService;

@Controller
@ComponentScan("service")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String test() {
        return "index";
    }

    @GetMapping(value = "/user")
    public String getUsers(Model model) {
        model.addAttribute("userlist", userService.getUserById(1));
        return "users";
    }
}
