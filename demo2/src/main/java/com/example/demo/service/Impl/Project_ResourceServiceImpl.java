package com.example.demo.service.Impl;

import com.example.demo.entity.Project;
import com.example.demo.entity.Project_Resources;
import com.example.demo.entity.Resources;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.Project_ResourcesRepository;
import com.example.demo.repository.ResourcesRepository;
import com.example.demo.service.Project_ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Project_ResourceServiceImpl extends Throwable implements Project_ResourceService {
    @Autowired
    private Project_ResourcesRepository project_ResourceRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourcesRepository resourcesRepository;

    @Autowired
    public void setProject_ResourceRepository(Project_ResourcesRepository project_ResourceRepository) {
        this.project_ResourceRepository = project_ResourceRepository;
    }

    @Override
    public Project_Resources addProject_Resources(Project_Resources project_Resource) {
        return project_ResourceRepository.save(project_Resource);
    }

    @Override
    public List<Project_Resources> getAllProject_Resources() {
        return (List<Project_Resources>) project_ResourceRepository.findAll();
    }

    @Override
    public Project_Resources getProject_ResourcesByid(int record_id) {
        return project_ResourceRepository.findById(record_id).orElse(null);
    }


    @Override
    public boolean createProjectResources(Project_Resources projectResources, Project project, Resources resources) {
        if (project == null || resources == null) return false;
        project_ResourceRepository.save(projectResources);
        projectResources.setResources(resources);
        projectResources.setProject(project);
        projectRepository.save(project);
        resourcesRepository.save(resources);

        return true;
    }

    @Override
    public Project_Resources addResourcesToProject(Project_Resources projectResources,Project project, Resources resource) {
        project.getProjectId();
        List<Project_Resources> list = project_ResourceRepository.findByProject(project);
        projectResources.setResources(resource);
        return project_ResourceRepository.save(projectResources);

    }

    @Override
    public void deleteResourceFromProject(Project project, Resources resources) {

    }

    @Override
    public void deleteResourcesFromProject(Resources resources, Project project){
        Integer projectId = project.getProjectId();
        Integer resourceId = resources.getResourceId();
        /*project_ResourceRepository.deleteByProjectIdAndResourceId(resourceId,projectId);*/
    }


    @Override
    public List<Project_Resources> findByProject(Project project) {
        return project_ResourceRepository.findByProject(project);
    }

}
