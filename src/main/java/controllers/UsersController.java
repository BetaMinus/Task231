package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserServiceImpl userService;

    //Получить список всех
    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("usersList", userService.readAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.read(id));
        return "read";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.read(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.update(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.delete(userService.read(id));
        return "redirect:/users";
    }

}
