package org.launchcode.health_recipe.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    protected Integer id;

//  Removed active name from AbstractEntity. Id is there for James' authentication controller. This class matches the
//    request that James had for it's makeup.
//
//    @NotNull
//    @Size(max = 150)
//    protected String name;

    public Integer getId() {
        return id;
    }

//    Because of removing name, then getters and setters can quiet down as well.
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntity that = (AbstractEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
