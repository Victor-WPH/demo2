package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Project_columns {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int column_id;

    @Column
    private int projectId;

    @Column
    private String columnName;

    @Enumerated
    @Column
    private ColumnType type;

    @ManyToOne
    private Project_columns project_columns;

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public Project_columns getProject_columns() {
        return project_columns;
    }

    public void setProject_columns(Project_columns project_columns) {
        this.project_columns = project_columns;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public ColumnType getType() {
        return type;
    }

    public void setType(ColumnType type) {
        this.type = type;
    }

}
