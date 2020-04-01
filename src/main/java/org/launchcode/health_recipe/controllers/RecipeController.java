package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.launchcode.health_recipe.models.RecipeData;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping(value = "list")
public class RecipeController {

    @Autowired
    RecipeData recipeData;

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController () {

        columnChoices.put("all", "All");
    }

    @RequestMapping("")
    public String list(Model model, Pageable page) {
        Page<Recipe> recipes;
        model.addAttribute("recipes", recipeData.findAllByPage(page));
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

