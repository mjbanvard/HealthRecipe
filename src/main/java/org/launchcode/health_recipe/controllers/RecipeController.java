package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import org.launchcode.health_recipe.models.RecipeData;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class RecipeController {

    @Autowired
    RecipeData recipeData;

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController() {

        columnChoices.put("all", "All");
    }

    @RequestMapping("/list")
    public String list(Model model, Pageable page) {
        Page<Recipe> recipes;
        model.addAttribute("recipes", recipeData.findAllByPage(page));
        return "list";
    }

    @GetMapping("view/{recipeId}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {

        Optional optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe) optRecipe.get();
            model.addAttribute("recipes", recipe);
            return "view";
        } else {
            return "redirect:../";
        }
    }
}


