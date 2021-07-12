package com.example.demo.service.Impl;

import com.example.demo.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;

import java.util.List;



@Service
public class ProjectServiceImpl extends Throwable implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public void setProductRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project getProjectByid(int project_id) {
        return projectRepository.findById(project_id).orElse(null);
    }

    @Override
    public void deleteProjectById(int project_id) {
         projectRepository.deleteById(project_id);
         System.out.println(project_id + "is deleted");

    }


}

