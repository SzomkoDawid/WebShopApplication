package com.example.webshop.user;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = {"user/users"}, method = RequestMethod.GET)
    public String findAllUsers(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "user/users";
    }

    @RequestMapping(value = {"/", "login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/login");
        return modelAndView;
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
            model.addObject("log", "Powrót do logowania");
            model.addObject("user", new User());
            model.setViewName("user/signup");
        }
        return model;
    }
}

