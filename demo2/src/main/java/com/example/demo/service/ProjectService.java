package com.example.demo.service;

import com.example.demo.entity.Project;

import java.util.List;

public interface ProjectService {
    public Project addProject(Project project);
    public List<Project> getAllProjects();
    public Project getProjectByid(int project_id);

    void deleteProjectById(int project_id);
}