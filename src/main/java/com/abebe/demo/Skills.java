package com.abebe.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min=3)
    private String skillType;
    @NotNull
    private String rating;

    public long getId() {
        return id;
    }

    public String getSkillType() {
        return skillType;
    }

    public String getRating() {
        return rating;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
