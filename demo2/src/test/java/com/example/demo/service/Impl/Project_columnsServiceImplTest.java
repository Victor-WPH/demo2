package com.example.demo.service.Impl;

import com.example.demo.entity.Project;
import com.example.demo.entity.Project_columns;
import com.example.demo.repository.Project_columnsRepository;
import com.example.demo.service.ProjectService;
import com.example.demo.service.Project_columnsService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static com.example.demo.entity.ColumnType.FORMULA;

@SpringBootTest
public class Project_columnsServiceImplTest {

    @Autowired
    private Project_columnsRepository project_columnsRepository;

    @Autowired
    private Project_columnsService project_columnsService;

    @Autowired
    private ProjectService projectService;

    @Test
    void contextLoads() {
    }


    @Test
    void addProject_columns() {
        Project project = new Project();
        projectService.addProject(project);
        Project_columns projectColumns = new Project_columns();
        projectColumns.setProjectId(2);
        projectColumns.setColumn_id(3);
        projectColumns.setColumn_name("column1");
        projectColumns.setType(FORMULA);
        Project_columns test = project_columnsService.addProject_columns(projectColumns);
        Assert.assertNotEquals(null, test);

    }

    @Test
    void getAllProject_columns() {
       /* Project project = new Project();
        Project_columns projectColumns = new Project_columns();
        projectColumns.setProject_id(2);
        projectColumns.setColumn_id(3);
        projectColumns.setColumn_name("column1");
        projectColumns.setType(FORMULA);
        projectColumns.setProject(project);*/
        List<Project_columns> result = project_columnsService.getAllProject_columns();
        /*Optional<Project_columns> result = Optional.of(project_columnsRepository.getById(2));*/
        Assertions.assertNotEquals(null,result);

    }

    @Test
    void getProject_columnsById() {
        /*Project project = new Project();
        Project_columns projectColumns = new Project_columns();
        projectColumns.setProject_id(2);
        projectColumns.setColumn_id(3);
        projectColumns.setColumn_name("column1");
        projectColumns.setType(FORMULA);
        projectColumns.setProject(project);*/
        Project_columns test = project_columnsService.getProject_columnsById(2);
        Optional<Project_columns> result = Optional.of(project_columnsRepository.getById(2));
        /*System.out.println("reach");*/
        Assertions.assertNotEquals(test,result);

    }

    }
