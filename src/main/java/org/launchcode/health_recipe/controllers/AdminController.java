package org.launchcode.health_recipe.controllers;


import org.launchcode.health_recipe.models.Ingredient;
import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.RecipeData;
import org.launchcode.health_recipe.models.User;
import org.launchcode.health_recipe.models.data.IngredientRepository;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.launchcode.health_recipe.models.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping
public class AdminController {

    @Autowired
    private RecipeRepository recipeRepository;

    private Recipe recipe;

    @Autowired
    private IngredientRepository ingredientRepository;

    private Ingredient ingredient;

    @Autowired
    private UserRepository userRepository;


    private User user;

    @Autowired
    RecipeController recipeController;

    @Autowired
    RecipeData recipeData;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public AdminController() {

        columnChoices.put("all", "All");
    }

    @GetMapping("admin-home")
    public String displayAdminHomePage(Model model) {
        model.addAttribute("title","Welcome Admin");
        return "/admin-home";
    }

    @RequestMapping("admin/list")
    public String list(Model model, Pageable page) {
        Page<Recipe> recipes;
        model.addAttribute("recipes", recipeData.findAllByPage(page));
        return "admin/list";
    }


    @RequestMapping(value = "recipes")
    public String listRecipeByChoice(Model model, @RequestParam String column,
                                     @RequestParam ArrayList<String> value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipe Choice");
        }
        model.addAttribute("recipes", recipes);

        return "admin/list-recipes";
    }
}