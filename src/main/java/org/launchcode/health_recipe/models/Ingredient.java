package org.launchcode.health_recipe.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ingredient extends AbstractEntity {

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 1000, message = "Ingredient must be only 3-1000 characters.  Please try again.")
    private String ingredient;
    
    public Ingredient(String ingredient){
        this.ingredient = ingredient;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }
}