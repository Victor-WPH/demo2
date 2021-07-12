package com.example.demo.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Resource_Details {
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int record_id;

    @CreatedDate
    private LocalDate time_created;

    @LastModifiedDate
    private LocalDate last_updated;

    @Column
    private int resource_id;

    @Column
    private int column_value;

    @Column
    private int column_id;

    public Resource_Details(int record_id, LocalDate time_created, LocalDate last_updated, int resource_id, int column_value, int column_id) {
        this.record_id = record_id;
        this.time_created = time_created;
        this.last_updated = last_updated;
        this.resource_id = resource_id;
        this.column_value = column_value;
        this.column_id = column_id;
    }

    @ManyToOne (targetEntity = Resources.class)
    private Resources resources;

    @ManyToOne (targetEntity = Project_columns.class)
    private Project_columns project_columns;

    public Resource_Details() {

    }


    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
        this.time_created = time_created;
    }

    public LocalDate getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDate last_updated) {
        this.last_updated = last_updated;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getColumn_value() {
        return column_value;
    }

    public void setColumn_value(int column_value) {
        this.column_value = column_value;
    }

    public int getColumn_id() {
        return column_id;
    }

    public void setColumn_id(int column_id) {
        this.column_id = column_id;
    }


}
