package com.example.demo.service.Impl;

import com.example.demo.entity.Resource_Details;
import com.example.demo.repository.Resource_DetailsRepository;
import com.example.demo.service.ResourceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ResourceDetailsServiceImpl extends Throwable implements ResourceDetailsService {

    private Resource_DetailsRepository resourceDetailsRepository;

    @Autowired
    public void setResource_DetailsRepository(Resource_DetailsRepository resourceDetailsRepository) {
        this.resourceDetailsRepository = resourceDetailsRepository;
    }

    @Override
    public Resource_Details addResource_Details(Resource_Details resourceDetails) {
        return resourceDetailsRepository.save(resourceDetails);
    }

    @Override
    public List<Resource_Details> getAllResource_Details() {
        return (List<Resource_Details>) resourceDetailsRepository.findAll();
    }

    @Override
    public Resource_Details getResource_DetailsByid(int record_id) {
        return resourceDetailsRepository.findById(record_id).orElse(null);
    }
}

    /*@Override
    public Resource_Details get()
}
*/
