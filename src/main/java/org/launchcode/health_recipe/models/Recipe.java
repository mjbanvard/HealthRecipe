package org.launchcode.health_recipe.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @NotNull (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    public Recipe() {}

    public Recipe(String servings, String timeToServe, String stepsToRecipe) {
        super();
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }


    public String getServings() {
        return servings;
    }


    public String getServe_time() {
        return serve_time;
    }


    public String getSteps() {
        return steps;
    }

}
