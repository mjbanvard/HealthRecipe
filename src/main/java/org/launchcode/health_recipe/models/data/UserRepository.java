package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer> {
    User findByUsername(String username);
}
