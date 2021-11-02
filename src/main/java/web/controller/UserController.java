package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String getAllUsers(Model model) {
        model.addAttribute("listUsers", userService.allUser());
        return "list";
    }


    @GetMapping("/{id}")
    public String findId(@PathVariable("id")Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "show";
    }


    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("newUser",new User());
        return "create";
    }


    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model,@PathVariable("id")long id) {
        model.addAttribute("user",userService.getById(id));
        return "edit";
    }


    @PatchMapping("{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(id,user);
        return "redirect:/users";
    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id")long id) {
        userService.remove(id);
        return "redirect:/users";
    }

}