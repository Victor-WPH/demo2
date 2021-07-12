package com.example.demo.service.Impl;

import com.example.demo.entity.Resource_Details;
import com.example.demo.entity.Resources;
import com.example.demo.repository.Resource_DetailsRepository;
import com.example.demo.service.ResourceDetailsService;
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
class ResourceDetailsServiceImplTest {

    @Autowired
    private ResourceDetailsService resourceDetailsService;

    @Autowired
    private Resource_DetailsRepository resourceDetailsRepository;

    @Autowired
    private ResourceService resourceService;

    @Test
    void addResource_Details() {
        Resources resources = new Resources();
        resourceService.addResource(resources);
        Resource_Details resource_details = new Resource_Details();
        resource_details.setResource_id(1);
        resource_details.setColumn_id(2);
        resource_details.setColumn_value(10);
        resource_details.setRecord_id(5);
        resource_details.setLast_updated(LocalDate.now());
        resource_details.setTime_created(LocalDate.of(2021, 07, 05));
        Resource_Details test = resourceDetailsService.addResource_Details(resource_details);
        Assert.assertNotEquals(null, test);
    }

    @Test
    void getAllResource_Details() {
        List<Resource_Details> result = resourceDetailsService.getAllResource_Details();
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void getResource_DetailsByid() {
        Resource_Details test = resourceDetailsService.getResource_DetailsByid(1);
        Optional<Resource_Details> result = Optional.of(resourceDetailsRepository.getById(1));
        Assertions.assertNotEquals(test,result);
    }
}