package com.example.demo.repository;

import com.example.demo.entity.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends JpaRepository <Resources,Integer> {

}
