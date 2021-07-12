package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Project_Resources;
import com.example.demo.entity.Resources;

import java.util.List;

public interface Project_ResourceService {
    public Project_Resources addProject_Resources(Project_Resources user);
    public List<Project_Resources> getAllProject_Resources();
    public Project_Resources getProject_ResourcesByid(int record_id);
    /*public Project_Resources createProjectResources(Project_Resources projectResources, Resources resource, Resources resources);*/

    boolean createProjectResources(Project_Resources projectResources, Project project, Resources resources);

    Project_Resources addResourcesToProject(Project_Resources Project_Resources, Project project, Resources resource);

    void deleteResourceFromProject (Project project, Resources resources);

    void deleteResourcesFromProject(Resources resources, Project project);

    public List<Project_Resources> findByProject (Project project);

}

