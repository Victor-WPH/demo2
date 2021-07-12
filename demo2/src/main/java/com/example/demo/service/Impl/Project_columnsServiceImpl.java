package com.example.demo.service.Impl;

import com.example.demo.entity.Project_columns;
import com.example.demo.repository.Project_columnsRepository;
import com.example.demo.service.Project_columnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Project_columnsServiceImpl extends Throwable implements Project_columnsService {



    private Project_columnsRepository project_columnsRepository;

    @Autowired
    public void setProject_columnsRepository(Project_columnsRepository project_columnsRepository) {
        this.project_columnsRepository = project_columnsRepository;
    }

    @Override
    public Project_columns addProject_columns(Project_columns project_columns) {
        return project_columnsRepository.save(project_columns);
    }

    @Override
    public List<Project_columns> getAllProject_columns() {
        return (List<Project_columns>) project_columnsRepository.findAll();
    }

    @Override
    public Project_columns getProject_columnsById(int column_id) {
        return project_columnsRepository.findById(column_id).orElse(null);
    }
}

