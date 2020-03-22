package org.launchcode.health_recipe.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe {

    @Id
    @NotNull (message = "Name?")
    private String name;

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @NotNull (message = "Recipe steps?")
    @Column(length=15500)
    private String steps;

    public Recipe() {}

    public Recipe(String name, String servings, String timeToServe, String stepsToRecipe) {
        this.name = name;
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServings() {
        return servings;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }

    public String getServe_time() {
        return serve_time;
    }

    public void setServe_time(String serve_time) {
        this.serve_time = serve_time;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }
}
