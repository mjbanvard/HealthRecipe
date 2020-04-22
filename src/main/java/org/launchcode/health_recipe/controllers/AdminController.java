package org.launchcode.health_recipe.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin-home")
    public String displayAdminHomePage() {
        return "admin-home";
    }
}
