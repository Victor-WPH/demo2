package com.example.demo.repository;

import com.example.demo.entity.Project;
import com.example.demo.entity.Project_Resources;
import com.example.demo.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Project_ResourcesRepository extends JpaRepository <Project_Resources, Integer> {
//    public Project_Resources deleteByProjectAndResource(Project project, Resources resources);
    /*public List<Project_Resources> findByProjectAndResources(Project project, Resources resources);*/
    public List<Project_Resources> findByProject(Project project);


}
