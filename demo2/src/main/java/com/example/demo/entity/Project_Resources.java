package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class Project_Resources {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int recordId;

    @CreatedDate
    private LocalDate time_created;

    @Column
    private int project_id;

    @Column
    private int resource_id;

    @ManyToOne (targetEntity = Project.class)
    private Project project;

    @ManyToOne (targetEntity = Resources.class)
    private Resources resources;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Project_Resources(int record_id, LocalDate time_created, int project_id, int resource_id) {
    }

    public Project_Resources() {

    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
        this.time_created = time_created;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }
}
