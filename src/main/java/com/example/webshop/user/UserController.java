package com.example.webshop.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/users", "roleName"}, method = RequestMethod.GET)
    public Model findAllUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        return model;
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();
        model.setViewName("user/login");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public ModelAndView signup() {
        ModelAndView model = new ModelAndView();
        User user = new User();
        model.addObject("user", user);
        model.setViewName("user/signup");
        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView addUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
        User existLogin = userService.findByLogin(user.getLogin());
        User existEmail = userService.findByEmail(user.getEmail());

        if (existLogin != null) {
            bindingResult.rejectValue("login", "error.user", "Wybrany login jest zajęty!");
        }
        if (existEmail != null) {
            bindingResult.rejectValue("email", "error.user", "Wybrany e-mail jest zajęty!");
        }
        if (bindingResult.hasFieldErrors()) {
            model.setViewName("user/signup");
        } else {
            userService.saveUser(user);
            model.addObject("msg", "Użytkownik został zarejestrowany pomyślnie!");
            model.addObject("log", "zaloguj się");
            model.addObject("user", new User());
            model.setViewName("user/signup");
        }
        return model;
    }

    @RequestMapping(value = {"/home/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByLogin(auth.getName());

        model.addObject("userName", user.getFirstName() + " " + user.getLastName());
        model.addObject("address", user.getAddress());
        model.addObject("avatar", user.getAvatarUrl());
        model.setViewName("home/home");
        return model;
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public ModelAndView  accessDenied() {
        ModelAndView model = new ModelAndView();
        model.setViewName("errors/access_denied");
        return model;
    }
}

