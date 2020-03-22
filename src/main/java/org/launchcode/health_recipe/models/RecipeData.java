package org.launchcode.health_recipe.models;

import java.util.ArrayList;

// This is a change made in sandbox.

/**
 * Created by LaunchCode
 */
public class RecipeData {


    /**
     * Returns the results of searching the Recipes data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Recipe field that should be searched.
     * @param value Value of the field to search for.
     * @param allRecipes The list of recipes to search.
     * @return List of all recipes matching the criteria.
     */
    public static ArrayList<Recipe> findByColumnAndValue(String column, String value, Iterable<Recipe> allRecipes) {
        ArrayList<Recipe> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Recipe>) allRecipes;
        }

        if (column.equals("all")){
            results = findByValue(value, allRecipes);
            return results;
        }
//        for (Recipe recipe : allRecipes) {
//
//            String aValue = getFieldValue(recipe, column);
//
//            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
//                results.add(recipe);
//            }
//        }

        return results;

    }

//    public static String getFieldValue(Recipe recipe, String fieldName){
//        String theValue;
//        if (fieldName.equals("name")){
//            theValue = recipe.getName();
//        } else if (fieldName.equals("employer")){
//            theValue = recipe.getEmployer().toString();
//        } else {
//            theValue = recipe.getSkills().toString();
//        }
//
//        return theValue;
//    }

    /**
     * Search all Recipe fields for the given term.
     *
     * @param value The search term to look for.
     * @param allRecipes The list of recipes to search.
     * @return      List of all recipes with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value, Iterable<Recipe> allRecipes) {

        ArrayList<Recipe> results = new ArrayList<>();
        for (Recipe recipe : allRecipes) {
            if (recipe.getName().toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
//            } else if (recipe.getEmployer().toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(recipe);
//            } else if (recipe.getSkills().toString().toLowerCase().contains(value.toLowerCase())) {
//                results.add(recipe);
            } else if (recipe.toString().toLowerCase().contains(value.toLowerCase())) {
                results.add(recipe);
            }
        }
        return results;
    }
}