package com.example.webshop.user;

import com.example.webshop.user.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

   private UserService userService;
   private RoleService roleService;


   @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping({"/users", "roleName"})
    public String findAllUsers(Model model){
       model.addAttribute("userList", userService.findAll());
       return "users";
    }
 /*   @RequestMapping(value = "/users/{roleName}", method = RequestMethod.GET)
    public String findUserByRole (Model model, @PathVariable(name = "roleName") String roleName){
       model.addAttribute(userService.findUserByRoles(roleName));
       return "users";
    }*/
    }

