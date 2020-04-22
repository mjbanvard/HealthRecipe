//package org.launchcode.health_recipe.models;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//public class Ingredient {
//
//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(max = 150)
//    private String recipeName;
//
//
//
//    @NotBlank(message = "Please provide Recipe ingredient.")
//    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
//    @ManyToMany/*(targetEntity = "recipe")*/
//    public String ingredient;
//
////    @ManyToOne
////    @JoinColumn(/*name="recipe_name",*/ nullable=false)
////    protected Recipe recipe;
//
//    @Override
//    public String toString() {
//        return recipeName;
//    }
//
//    public Ingredient(int id, String name, String ingredient){
//
//        this.id = id;
//        this.recipeName = name;
//        this.ingredient = ingredient;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return recipeName;
//    }
//
//    public void setName(String name) {
//        this.recipeName = name;
//    }
//
//    public Ingredient() {}
//
//    public String getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(String ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Ingredient that = (Ingredient) o;
//        return id == that.id &&
//                recipeName.equals( that.recipeName ) &&
//                ingredient.equals( that.ingredient );
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash( id, recipeName, ingredient );
//    }
//}
package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @ManyToOne
    private Recipe recipe;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    private String ingredient;

    public Ingredient() {}

    public Ingredient(Recipe aRecipe, String anIngredient){
        super();
        this.recipe = aRecipe;
        this.ingredient = anIngredient;
    }

//    @OneToMany
////    @JoinColumn(name="recipeId")
//    private final List<Recipe> recipes = new ArrayList<>();

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe aRecipe) {
        this.recipe = aRecipe;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}