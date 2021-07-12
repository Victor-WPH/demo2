package com.example.demo.service.Impl;


import com.example.demo.entity.Resources;
import com.example.demo.repository.ResourcesRepository;
import com.example.demo.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResourceServiceImpl extends Throwable implements ResourceService {

    private ResourcesRepository resourcesRepository;

    @Autowired
    public void setResourcesRepository(ResourcesRepository resourcesRepository) {
        this.resourcesRepository = resourcesRepository;
    }

    @Override
    public Resources addResource(Resources resources) {
        return resourcesRepository.save(resources);
    }

    @Override
    public List<Resources> getAllResources() {
        return (List<Resources>) resourcesRepository.findAll();
    }





    @Override
    public Resources getResourceByid(Integer resourceId) {
        return resourcesRepository.findById(resourceId).orElse(null);
    }

    @Override
    public List<Resources> findAll() {
        return null;
    }

    @Override
    public void deleteResourceByid(Integer resource_id) {
        resourcesRepository.deleteById(resource_id);
        System.out.println(resource_id + "is deleted");
    }
}



