package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Resources {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int resourceId;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate time_created;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate last_updated;

    @OneToMany(mappedBy = "resources")
    Set<Resource_Details> resource_detailsSet = new HashSet<>();

    @OneToMany(mappedBy = "resources")
    Set<Project_Resources> project_resources = new HashSet<>();

    public Resources(int resourceId, LocalDate time_created, LocalDate last_updated) {
        this.resourceId = resourceId;
        this.time_created = time_created;
        this.last_updated = last_updated;
    }

    public Resources() {

    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Set<Resource_Details> getResource_detailsSet() {
        return resource_detailsSet;
    }

    public void setResource_detailsSet(Set<Resource_Details> resource_detailsSet) {
        this.resource_detailsSet = resource_detailsSet;
    }

    public Set<Project_Resources> getProject_resources() {
        return project_resources;
    }

    public void setProject_resources(Set<Project_Resources> project_resources) {
        this.project_resources = project_resources;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
        this.time_created = time_created;
    }

    public LocalDate getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDate last_updated) {
        this.last_updated = last_updated;
    }
}
