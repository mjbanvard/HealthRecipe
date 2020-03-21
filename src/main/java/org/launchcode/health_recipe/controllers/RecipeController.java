package org.launchcode.health_recipe.controllers;

import org.launchcode.health_recipe.models.Recipe;
import org.launchcode.health_recipe.models.RecipeData;
import org.launchcode.health_recipe.models.data.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@Controller
@RequestMapping("recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public RecipeController () {

        columnChoices.put("all", "All");
//        columnChoices.put("employer", "Employer");
//        columnChoices.put("skill", "Skill");

    }

    @GetMapping
    public String displayAllRecipes(Model model) {
        model.addAttribute("title", "All Recipes");
        model.addAttribute( "recipes", recipeRepository.findAll() );
        return "recipes/index";
    }

    @GetMapping("add")
    public String displayAddRecipeForm(Model model) {
        model.addAttribute( new Recipe() );
        return "recipes/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Recipe newRecipe,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "recipes/add";
        }

        recipeRepository.save(newRecipe);
        return "redirect:";
    }

    @GetMapping("view/{name}")
    public String displayViewRecipe(Model model, @PathVariable int recipeId) {

        Optional<Recipe> optRecipe = recipeRepository.findById(recipeId);
        if (optRecipe.isPresent()) {
            Recipe recipe = (Recipe)optRecipe.get();
            model.addAttribute( "recipes", recipe );
            return "list-recipes";
        } else {
            model.addAttribute( "recipes", recipeRepository.findAll() );
            return "redirect:../";
        }
    }

    @RequestMapping(value = "recipes")
    public String listRecipesByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Recipe> recipes;
        if (column.toLowerCase().equals("all")){
            recipes = recipeRepository.findAll();
            model.addAttribute("title", "All Recipes");
        } else {
            recipes = RecipeData.findByColumnAndValue(column, value, recipeRepository.findAll());
            model.addAttribute("title", "Recipes with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("recipes", recipes);

        return "list-recipes";
    }
}

