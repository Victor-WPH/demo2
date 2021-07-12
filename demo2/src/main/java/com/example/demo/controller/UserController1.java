/*
package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;


    @GetMapping("/getProject/{project_id}")
    public ResponseEntity<?> getUserByUsername(Principal principal, @RequestParam(name = "username") String username) {
        User currentUser = userService.get(principal);
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("{The user has not found}", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
*/

    /*@GetMapping("/getAll")
    public ResponseEntity<?> getAllUser() {
        List<User> UserList = userService.findAllUsers();
        return new ResponseEntity<>(UserList, HttpStatus.OK);
    }
}
*/
    /*@PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User user_new = userService.create(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUserByUsername(@RequestParam("username") String username) {
        userService.delete(username);
        User user = userService.findByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
*/


