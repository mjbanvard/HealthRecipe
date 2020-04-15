package org.launchcode.health_recipe.models;

import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(max = 150)
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "name")
    private String recipeName;

//    @NaturalId
//    private int recipeId;

    @NotBlank(message = "Please provide Recipe ingredient.")
    @Size(min = 3,max = 255, message = "Ingredient must be only 3-255 characters.  Please try again.")
    @JoinColumn (referencedColumnName = "ingredient")
//    @ManyToOne (fetch = FetchType.LAZY)
    private String ingredient;

    @Override
    public String toString() {
        return ingredient;
    }

    public Ingredient(int id, String recipeName, String ingredient){
// Adjusted items and added recipe.Id, as ints are better for foreign keys than Strings

        this.id = id;
        this.recipeName = recipeName;
//        this.recipeId = recipe.id;
        this.ingredient = ingredient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return recipeName;
    }

    public void setName(String name) {
        this.recipeName = name;
    }

    public Ingredient() {}

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id &&
                recipeName.equals( that.recipeName ) &&
                ingredient.equals( that.ingredient );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, recipeName, ingredient );
    }
}
