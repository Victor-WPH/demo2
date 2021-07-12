package com.example.demo.service.Impl;

import com.example.demo.entity.Project;
import com.example.demo.entity.User;
import com.example.demo.repository.ProjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProjectServiceImplTest {
    @Mock
    private ProjectRepository projectRepository;

    @Autowired
    @InjectMocks
    private ProjectServiceImpl projectService;
    private Project project1;
    private Project project2;
    List<Project> projectList;


    @BeforeEach
    void setUp() {
        User owner1 = new User();
        projectList = new ArrayList<>();
        project1 = new Project(1, LocalDate.of(2021, 06, 30), owner1);

        project2 = new Project();
        project2.setOwner(new User());
        project2.setTime_created(LocalDate.of(2021,05,8));
        project2.setProjectId(2);


        projectList.add(project1);
        projectList.add(project2);
    }


    @AfterEach
    void tearDown() {
        project1 = project2 = null;
        projectList = null;
    }

    @Test
    void addProject() throws ProjectAlreadyExistsException {
        when(projectRepository.save(any())).thenReturn(project1);
        projectService.addProject(project1);
        verify(projectRepository,times(1)).save(any());
    }


    @Test
    void getAllProjects() {


        projectRepository.save(project1);
        when(projectRepository.findAll()).thenReturn(projectList);
        List<Project> projectList1 = projectService.getAllProjects();
        assertEquals(projectList1, projectList);
        verify(projectRepository, times(1)).save(project1);
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void getProjectByid() {
        Mockito.when(projectRepository.findById(1)).thenReturn(Optional.ofNullable(project1));
        assertThat(projectService.getProjectByid(project1.getProjectId())).isEqualTo(project1);
    }

    private class ProjectAlreadyExistsException extends Exception {
    }
}


