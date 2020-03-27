package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.launchcode.health_recipe.models.RecipeData;

import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping(value = "list")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController () {

        columnChoices.put("all", "All");
    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "list";
    }

    @RequestMapping(value = "recipes")
    public String listRecipeByChoice(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipe Choice " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }
}

