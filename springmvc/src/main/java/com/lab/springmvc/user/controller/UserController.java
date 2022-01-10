package com.lab.springmvc.user.controller;

import com.lab.springmvc.user.domain.User;
import com.lab.springmvc.user.dto.UserDto;
import com.lab.springmvc.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/register")
    public String createUser(Model model) {
        model.addAttribute("form", new UserDto());
        return "users/createForm";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute UserDto userForm) {

        User createUser = new User();
        createUser.setEmail(userForm.getEmail());
        createUser.setBirthDate(userForm.getBirthDate());
        createUser.setPw(userForm.getPw());

        userService.register(createUser);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String doLogin(Model model) {
        model.addAttribute("info", new UserDto());
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UserDto userForm) {
        if (userService.login(userForm.getEmail(), userForm.getPw())) {
            return "users/loginComplete";
        } else {
            return "users/error";
        }
    }

}
