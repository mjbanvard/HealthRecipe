package org.launchcode.health_recipe.models.dto;

import javax.validation.constraints.Size;

public class RegisterFormDTO extends LoginFormDTO {

    private String verifyPassword;


    @Size(min=3, max=30, message = "Invalid name, must be between 3 and 30 characters.")
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }


    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
