package com.example.demo.service;


import com.example.demo.entity.Resources;

import java.util.List;

public interface ResourceService {
    public Resources addResource(Resources resource);
    public List<Resources> getAllResources();
    public Resources getResourceByid(Integer resource_id);

    List<Resources> findAll();

    void deleteResourceByid(Integer resource_id);
}