package org.launchcode.health_recipe.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Size(min=11)
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private String access;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String name, String email, String username, String password, String access) {
        super.setName(name);
        this.email = email;
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.access = access;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }
}
