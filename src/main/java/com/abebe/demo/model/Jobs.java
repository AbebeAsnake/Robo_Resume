package com.abebe.demo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Jobs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String jobTitle;
    private String jobDesc;
    private String organization;



    @ManyToMany()
    private Set<DesiredSkills> skill;
    @JoinTable(name = "desired_skill",
            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"))

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Collection<DesiredSkills> getSkill() {
        return skill;
    }

    public void setSkill(Set<DesiredSkills> skill) {
        this.skill = skill;
    }

    public void setOrganization(String organization) {

        this.organization = organization;
    }

    public String getOrganization() {
        return organization;
    }

    public Jobs(String jobTitle, String jobDesc, String organization) {
        this.jobTitle = jobTitle;
        this.jobDesc = jobDesc;
        this.organization = organization;


    }

    public Jobs() {
        this.skill = new HashSet<>();
    }



    public String getJobTitle() {
        return jobTitle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTittle() {
        return jobTitle;
    }

    public void setJobTittle(String jobTittle) {
        this.jobTitle = jobTittle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }




}
