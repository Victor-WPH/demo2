package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Project{
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    @Column(name = "projectId")
    private int projectId;

    @CreatedDate
    private LocalDate time_created;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    @ManyToOne
    private User owner;

    private String project_name;



    @OneToMany(mappedBy = "project_columns")
    Set<Project_columns> set = new HashSet<>();

    @OneToMany(mappedBy = "project")
    Set<Project_Resources> project_resources = new HashSet<>();

    public Project(){
}

    public Project(int projectId, LocalDate time_created, User owner) {
        this.projectId = projectId;
        this.time_created = time_created;
        this.owner = owner;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
        this.time_created = time_created;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<Project_columns> getSet() {
        return set;
    }

    public void setSet(Set<Project_columns> set) {
        this.set = set;
    }

    public Set<Project_Resources> getProject_resources() {
        return project_resources;
    }

    public void setProject_resources(Set<Project_Resources> project_resources) {
        this.project_resources = project_resources;
    }
}