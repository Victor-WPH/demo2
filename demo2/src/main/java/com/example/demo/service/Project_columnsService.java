package com.example.demo.service;

import com.example.demo.entity.Project_columns;
import com.example.demo.service.Impl.Project_columnsServiceImpl;

import java.util.List;

public interface Project_columnsService {
    public Project_columns addProject_columns(Project_columns project_columns);
    public List<Project_columns> getAllProject_columns();
    public Project_columns getProject_columnsById(int column_id);
}