package org.launchcode.health_recipe.models.data;

import org.launchcode.health_recipe.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
}