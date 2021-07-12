package com.example.demo.service;

import com.example.demo.entity.Resource_Details;

import java.util.List;

public interface ResourceDetailsService {
    public Resource_Details addResource_Details(Resource_Details resourceDetails);
    public List<Resource_Details> getAllResource_Details();
    public Resource_Details getResource_DetailsByid(int record_id);
}

