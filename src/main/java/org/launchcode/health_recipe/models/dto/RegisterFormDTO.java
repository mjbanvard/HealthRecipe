package org.launchcode.health_recipe.models.dto;

public class RegisterFormDTO extends LoginFormDTO {

    private String name;

    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public String getName() {
        return name;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.name = name;
        this.verifyPassword = verifyPassword;
    }
}
