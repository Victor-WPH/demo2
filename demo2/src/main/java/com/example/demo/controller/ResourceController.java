package com.example.demo.controller;
import com.example.demo.entity.Project_columns;
import com.example.demo.entity.Resource_Details;
import com.example.demo.entity.Resources;
import com.example.demo.service.Project_columnsService;
import com.example.demo.service.ResourceDetailsService;
import com.example.demo.service.ResourceService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private Project_columnsService projectColumnsService;

    @Autowired
    private ResourceDetailsService resourceDetailsService;

    @Autowired
    private UserService userService;

    @GetMapping("/getColumn/{column_id}")
    public ResponseEntity<?> getColumn(@PathVariable Integer column_id) {
        Project_columns projectColumns = projectColumnsService.getProject_columnsById(column_id);
        if (projectColumns == null) {
            return new ResponseEntity<>("The projectColumns is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(projectColumns, HttpStatus.OK);
    }

    @GetMapping("/getResource/{resourceId}")
    public ResponseEntity<?> getResource(@PathVariable Integer resourceId) {
        Resources resources = resourceService.getResourceByid(resourceId);
        if (resources == null) {
            return new ResponseEntity<>("The project is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }

    @GetMapping("/getAllResources")
    public ResponseEntity<?> getAllResources() {
        List<Resources> ResourceList = resourceService.getAllResources();
        return new ResponseEntity<>(ResourceList, HttpStatus.OK);
    }

    @PostMapping("/createColumns")
    public ResponseEntity<?> createColumns(@RequestBody Project_columns projectColumns) {
        Project_columns columns_new = projectColumnsService.addProject_columns(projectColumns);
        return new ResponseEntity<>(projectColumns, HttpStatus.CREATED);
    }

    @PostMapping("/createResources")
    public ResponseEntity<?> createResources(@RequestBody Resources resources) {
        Resources resources_new = resourceService.addResource(resources);
        return new ResponseEntity<>(resources, HttpStatus.CREATED);
    }

    @PostMapping("/updateColumn/{oldColumnName}/{columnName}")
    public ResponseEntity<?> updateColumns(@PathVariable String oldColumnName, @PathVariable String columnName) {
        Project_columns columnToUpdate = projectColumnsService.getProject_columnsByName(oldColumnName);
        boolean isSuccessful = projectColumnsService.updateProject_columns(columnToUpdate, columnName);
        if (isSuccessful) {
            return new ResponseEntity<>(columnToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"column does not exist!\"}", HttpStatus.BAD_REQUEST);

    }


    @DeleteMapping("/deleteColumns/{column_id}")
    public void deleteColumns(@PathVariable final int column_id) {
        projectColumnsService.deleteColumnById(column_id);
    }

    @DeleteMapping("/deleteResource/{resourceId}")
    public void deleteResource(@PathVariable final int resourceId) {
        resourceService.deleteResourceByid(resourceId);
    }
}


   /* @PostMapping("/setEntry")
    public ResponseEntity<?> setEntry(@RequestParam(name = "resourceId") Integer resourceId, @RequestParam(name = "columnId") Integer columnId, @RequestParam(name = "value") String value) {
        Project_columns column = projectColumnsService.getProject_columnsById(columnId);
        if (column == null) {
            return new ResponseEntity<>("{\"error\":\"column does not exist!\"}", HttpStatus.BAD_REQUEST);
        }
        Resources resource = resourceService.getResourceByid(resourceId);
        if (resource == null) {
            return new ResponseEntity<>("{\"error\":\"resource does not exist!\"}", HttpStatus.BAD_REQUEST);
        }
        Resource_Details resourceDetails = resourceDetailsService.get(resource,column);
        if(resourceDetails == null){
            resourceDetails = new ResourceDetails();
            resourceDetails.setColumnValue(value);
            resourceDetailsService.create(resourceDetails,resource,column);
            return new ResponseEntity<>(resourceDetails, HttpStatus.OK);
        }
        resourceDetails.setColumnValue(value);
        boolean isSuccessful = resourceDetailsService.update(resourceDetails);
        if(isSuccessful){
            return new ResponseEntity<>(resourceDetails,HttpStatus.OK);
        }
        return new ResponseEntity<>("{\"error\":\"sth wrong happens:(\"}",HttpStatus.BAD_REQUEST);
    }
}
*/


