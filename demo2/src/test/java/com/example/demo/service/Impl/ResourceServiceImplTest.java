package com.example.demo.service.Impl;

import com.example.demo.entity.Resources;
import com.example.demo.repository.ResourcesRepository;
import com.example.demo.service.ResourceService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@SpringBootTest
class ResourceServiceImplTest {
    @Autowired
    private ResourcesRepository resourcesRepository;


    @Autowired
    private ResourceService resourceService;

    @Test
    void addResource() {
        Resources resources = new Resources();
        resources.setResourceId(2);
        resources.setTime_created(LocalDate.of(2021,07,03));
        resources.setLast_updated(LocalDate.now());
        Resources test = resourceService.addResource(resources);
        Assert.assertNotEquals(null, test);
    }
    @Test
    void getAllResources() {
        List<Resources> result = resourceService.getAllResources();
        Assertions.assertNotEquals(null,result);
    }
    @Test
    void getResourceByid() {
        Resources test = resourceService.getResourceByid(2);
        Optional<Resources> result = Optional.of(resourcesRepository.getById(2));
        Assertions.assertNotEquals(test,result);
    }
}