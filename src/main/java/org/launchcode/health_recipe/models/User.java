package org.launchcode.health_recipe.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class User extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;
//
//    @NotNull
//    @Size(max = 150)
//    private String name;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Size(min=9)
    private String email;

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    private String access;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String email, String username, String password, String access) {
        super();
        this.email = email;
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.access = access;
    }

    public int getUserId() {
        return id;
    }

    public void setUserId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals( id, user.id ) &&
                Objects.equals( email, user.email ) &&
                Objects.equals( username, user.username ) &&
                Objects.equals( pwHash, user.pwHash ) &&
                Objects.equals( access, user.access );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, email, username, pwHash, access );
    }
}
