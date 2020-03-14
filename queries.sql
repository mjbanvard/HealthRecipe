## Part 1: Test it with SQL
SELECT* FROM health_recipe.job;

--## Part 2: Test it with SQL
SELECT name from employer
WHERE location = 'St. Louis, MO';

--## Part 3: Test it with SQL
DROP TABLE job;

--## Part 4: Test it with SQL
SELECT name, description FROM health_recipe.skill WHERE id in(SELECT skills_id FROM job_skills WHERE skills_id IS NOT NULL);