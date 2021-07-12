package com.example.demo.service.Impl;

import com.example.demo.entity.Project;
import com.example.demo.entity.Project_Resources;
import com.example.demo.repository.Project_ResourcesRepository;
import com.example.demo.service.ProjectService;
import com.example.demo.service.Project_ResourceService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Project_ResourceServiceImplTest {

    @Autowired
    private Project_ResourcesRepository project_resourcesRepository;

    @Autowired
    private Project_ResourceService project_resourceService;

    @Autowired
    private ProjectService projectService;

    @Test
    void addProject_Resources() {
        Project project = new Project();
        projectService.addProject(project);
        Project_Resources projectResources = new Project_Resources();
        projectResources.setRecordId(1);
        projectResources.setResource_id(5);
        projectResources.setTime_created(LocalDate.now());
        Project_Resources test = project_resourceService.addProject_Resources(projectResources);
        Assert.assertNotEquals(null, test);

    }

    @Test
    void getAllProject_Resources() {
        List<Project_Resources> result = project_resourceService.getAllProject_Resources();
        Assertions.assertNotEquals(null,result);
    }

    @Test
    void getProject_ResourcesByid() {
        Project_Resources test = project_resourceService.getProject_ResourcesByid(1);
        Optional<Project_Resources> result = Optional.of(project_resourcesRepository.getById(1));
        Assertions.assertNotEquals(test,result);
    }
}