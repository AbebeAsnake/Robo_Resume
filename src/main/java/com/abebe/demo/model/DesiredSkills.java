package com.abebe.demo.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DesiredSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
  private long jobId;
    private String qualification;

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    @ManyToMany(mappedBy = "skill")

    private Set<Jobs> job;

    public Collection<Jobs> getJob() {
        return job;
    }

    public void setJob(Set<Jobs> job) {
        this.job = job;
    }

    public DesiredSkills( String qualification, long jobId) {

        this.qualification = qualification;
        this.jobId=jobId;
    }



    public DesiredSkills() {

        this.job = new HashSet<>();

    }

    public String getQualification() {

        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
