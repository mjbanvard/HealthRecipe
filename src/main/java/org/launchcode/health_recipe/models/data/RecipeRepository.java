package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository <Recipe, Integer> {
}
