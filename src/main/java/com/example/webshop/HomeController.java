package com.example.webshop;
import com.example.webshop.user.User;
import com.example.webshop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;
@Controller
public class HomeController {
    private UserService userService;
    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping(value = {"/default"}, method = RequestMethod.GET)
    public String defaultAfterLogin() {
        Collection<? extends GrantedAuthority> authorities;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        authorities = auth.getAuthorities();
        String myRole = authorities.toArray()[0].toString();
        String admin = "ADMIN";
        if (myRole.equals(admin)) {
            return "redirect:admin/admin";
        }
        return "redirect:home/home";
    }
    @RequestMapping(value = {"/home/home"}, method = RequestMethod.GET)
    public ModelAndView home(ModelAndView modelAndView){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByLogin(auth.getName());
        modelAndView.addObject("login", user.getLogin());
        modelAndView.addObject("avatar", user.getAvatarUrl());
        modelAndView.setViewName("home/home");
        return modelAndView;
    }
}