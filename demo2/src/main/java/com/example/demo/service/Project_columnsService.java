package com.example.demo.service;

import com.example.demo.entity.Project_columns;

import java.util.List;

public interface Project_columnsService {
    public Project_columns addProject_columns(Project_columns project_columns);
    public List<Project_columns> getAllProject_columns();
    public Project_columns getProject_columnsById(int column_id);

    Project_columns getProject_columnsByName(String columnName);

    public boolean updateProject_columns(Project_columns projectColumns, String newColumnName);

    void deleteColumnById(int column_id);
}