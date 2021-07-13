package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.entity.Resources;
import com.example.demo.entity.User;
import com.example.demo.entity.Project_Resources;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Project_columnsService project_columnsService;

    @Autowired
    private Project_ResourceService project_resourceService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;


    @GetMapping("/getProject/{project_id}")
    public ResponseEntity<?> getProjectByID(Principal principal, @PathVariable(name = "project_id") int project_id) {
        User currentUser = userService.get(principal);
        Project project = projectService.getProjectByid(project_id);
        if (project == null) {
            return new ResponseEntity<>("{The project has not found}", HttpStatus.BAD_REQUEST);
        }
        if (!currentUser.getUsername().equals(project.getOwner().getUsername())) {
            return new ResponseEntity<>("{This project is not belonging to the use}", HttpStatus.BAD_REQUEST);


        }

        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    /*@PostMapping("/addResource")
     public ResponseEntity<?> addResourceByProjectId(@RequestBody Integer projectId, @RequestBody Integer resourceId) {
         System.out.println(projectId);
         Project project = projectService.getProjectByid(projectId);
         if (project == null) {
             return new ResponseEntity<>("The project does not exist", HttpStatus.BAD_REQUEST);
         }
         Resources resources = resourceService.getResourceByid(resourceId);
         Project_Resources projectResources = new Project_Resources();
         boolean created = project_resourceService.createProjectResources(projectResources, project, resources);
         if (!created) {
             return new ResponseEntity<>("Resource does not created", HttpStatus.BAD_REQUEST);
         }

         return new ResponseEntity<>(projectResources, HttpStatus.OK);
     }
 */
    @PostMapping("/tryToAddResource")
    public ResponseEntity<?> addResourceByProjectId(@RequestBody Project_Resources projectResources) {
        Integer projectId = projectResources.getProject_id();
        Integer resourceId = projectResources.getResource_id();
        Project project = projectService.getProjectByid(projectId);
        if (project == null) {
            return new ResponseEntity<>("The project does not exist", HttpStatus.BAD_REQUEST);
        }
        Resources resources = resourceService.getResourceByid(resourceId);
        boolean created = project_resourceService.createProjectResources(projectResources, project, resources);
        if (!created) {
            return new ResponseEntity<>("Resource does not created", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(projectResources, HttpStatus.OK);
        /*return new ResponseEntity<Project_Resources>(projectResources,HttpStatus.OK);*/
    }

    /*public ResponseEntity<?> addResourceByProject(@RequestBody Project project, @RequestBody Resources resources) {


    }
*/
    @GetMapping("/getResourceByProjectId")
    public ResponseEntity<?> getResourceByProjectId(@RequestBody Project project) {
        if (project == null) {
            return new ResponseEntity<>("The project does not exist", HttpStatus.BAD_REQUEST);
        }
        List<Resources> res = new ArrayList<>();
        List<Project_Resources> list = project_resourceService.findByProject(project);
        for (Project_Resources projectResource : list) {
            Resources resource = projectResource.getResources();
            res.add(resource);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @GetMapping("/get/{resourceId}")
    public ResponseEntity<?> getResource(@PathVariable Integer resourceId) {
        Resources resources = resourceService.getResourceByid(resourceId);
        if (resources == null) {
            return new ResponseEntity<>("The project is not found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resources, HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public ResponseEntity<?> getAllProject() {
        List<Project> ProjectList = projectService.getAllProjects();
        return new ResponseEntity<>(ProjectList, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createProject(@RequestBody Project project) {
//      Project project1 = projectService.addProject(project);
        Project project2 = new Project();
        User owner = new User();
        project2.setOwner(owner);

        projectService.addProject(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }

//    @PostMapping("/create")
//    public void createProject() {
//        Project project = new Project();
//        project.setProject_id(5);
//        project.setTime_created(LocalDate.now());
//        projectService.addProject(project);
//    }



 /*@DeleteMapping("/delete/{project_id}")
    public ResponseEntity<?> deleteProjectByID(@PathVariable("project_id") int project_id) {
       projectService.deleteProjectById(project_id);
       Project project = projectService.getProjectByid(project_id);
       return new ResponseEntity<>(project, HttpStatus.OK);

    }
*/

    @DeleteMapping("/delete/{project_id}")
    public void delete(@PathVariable final int project_id) {
        projectService.deleteProjectById(project_id);
    }

    @DeleteMapping("/deleteResource")
    public ResponseEntity<?> deleteResourceByProjectIdAndResourceId(@RequestBody Project_Resources project_resources) {
        Project project = project_resources.getProject();
        Resources resources = project_resources.getResources();
        if (project == null || resources == null) {
            return new ResponseEntity<>("The project or resources is not found", HttpStatus.BAD_REQUEST);
        }
        /*project_resourceService.deleteResourcesFromProject(resources, project);*/
        return new ResponseEntity<>("Resources is deleted", HttpStatus.OK);
    }




}


//CRUD opertation resources by ProjectID



