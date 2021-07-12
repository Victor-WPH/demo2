package com.example.demo.repository;


import com.example.demo.entity.Project_columns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Project_columnsRepository extends JpaRepository<Project_columns, Integer> {

}
