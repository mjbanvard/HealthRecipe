package org.launchcode.health_recipe.models;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Recipe extends AbstractEntity {

//      Recipe Name
//      Servings
//      Start to Finish Time
//      Steps

//   @OneToMany
//    @NotNull(message = "Recipe name cannot be empty.")
//    private String recipe_name;

    @NotNull (message = "Servings?")
    private String servings;

    @NotNull (message = "Serve time?")
    private String serve_time;

    @Size(max = 5000, message = "Steps cannot exceed 20000 characters.")
    @NotNull (message = "Recipe steps?")
    private String steps;

    public Recipe() {}

    public Recipe(String servings, String timeToServe, String stepsToRecipe) {
        super();
//        this.recipe_name = recipeName;
        this.servings = servings;
        this.serve_time = timeToServe;
        this.steps = stepsToRecipe;
    }

// //   public String getRecipe_name() {
//        return recipe_name;
//    }

//    public void setRecipe_name(String recipe_name) {
//        this.recipe_name = recipe_name;
//    }

    public String getServings() {
        return servings;
    }

//    public void setServings(int servings) {
//        this.servings = servings;
//    }

    public String getServe_time() {
        return serve_time;
    }

//    public void setServe_time(int serve_time) {
//        this.serve_time = serve_time;
//    }

    public String getSteps() {
        return steps;
    }

//    public void setSteps(String steps) {
//        this.steps = steps;
//    }

    //    @ManyToOne
//    @NotNull(message = "Employer is required, please select an employer.")
//    private Employer employer;
//
//    @ManyToMany
//    @NotNull(message = "At least one skill required. Please select a skill.")
//    private List<Skill> skills = new ArrayList<>();
//
//    public Job() { }
//    public Job(Employer employer, List<Skill> skills) {
//        super();
//        this.employer = employer;
//        this.skills = skills;
//    }
//    public Employer getEmployer() { return employer; }
//    public void setEmployer(Employer employer) { this.employer = employer; }
//    public List<Skill> getSkills() { return skills; }
//    public void setSkills(List<Skill> skills) { this.skills = skills; }
}
