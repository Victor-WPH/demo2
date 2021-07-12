package com.example.demo.controller;
import com.example.demo.entity.Resources;
import com.example.demo.service.ResourceDetailsService;
import com.example.demo.service.ResourceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
/*@RequestMapping("/resource")*/
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceDetailsService resourceDetailsService;

    @Autowired
    private UserService userService;

    /*@GetMapping("/getResources/{resource_id}")
    public ResponseEntity<?> getResourcesByID(Principal principal, @RequestParam(name = "resource_id") Integer resource_id) {
        User currentUser = userService.get(principal);
        Resources resources = resourceService.getResourceByid(resource_id);
        if (resources == null) {
            return new ResponseEntity<>("{The resource has not found}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
*/
    @GetMapping("/get/{resourceId}")
    public ResponseEntity<?> getResource(@PathVariable Integer resourceId) {
        Resources resources = resourceService.getResourceByid(resourceId);
        if (resources == null) {
            return new ResponseEntity<>("The project is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllResources() {
        List<Resources> ResourceList = resourceService.getAllResources();
        return new ResponseEntity<>(ResourceList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createResources(@RequestBody Resources resources) {
        Resources resources_new = resourceService.addResource(resources);
        return new ResponseEntity<>(resources, HttpStatus.CREATED);
    }

    /*@DeleteMapping("/delete/{resource_id}")
    public ResponseEntity<?> deleteResourcesByID(@RequestParam("resource_id") int resource_id) {
        resourceService.deleteResourceByid(resource_id);
        *//*Resources resources = resourceService.getResourceByid(resource_id);*//*
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
*/
    /*@DeleteMapping("/delete/{resource_id}")
    public ResponseEntity<?> deleteResourcesByID(@RequestParam("resource_id") int resource_id) {
        Resources resources = resourceService.getResourceByid(resource_id);
        resourceService.deleteResourceByid(resource_id);
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }
}
*/
/*
    @DeleteMapping("/delete/{resource_id}")
    public void deleteResourcesByID(@RequestParam("resource_id") int resource_id) {
        resourceService.deleteResourceByid(resource_id);
    }
}*/
    @DeleteMapping("/delete/{resourceId}")
    public void delete(@PathVariable final int resourceId) {
        resourceService.deleteResourceByid(resourceId);
    }

    //CRUD project_columns
}