package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.example.demo.entity.Role.ADMIN;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveUser() {
        User user = new User();
        user.setPassword("12345567");
        user.setLast_updated(LocalDate.now());
        user.setUsername("username1");
        user.setTitle("Mr");
        user.setRole(ADMIN);
        user.setUserId(3);
        user.setProjectSet(user.getProjectSet());
        user.setSet(user.getSet());
        User test = userService.saveUser(user);
        Assert.assertNotEquals(null, test);
    }

    @Test
    void findByUsername() {
        /*Resource_Details test = resourceDetailsService.getResource_DetailsByid(1);
        Optional<Resource_Details> result = Optional.of(resourceDetailsRepository.getById(1));
        Assertions.assertNotEquals(test,result);
        */
        User test = userService.findByUsername("username1");
        Optional<User> result = Optional.of(userRepository.findByUsername("username1"));
        Assertions.assertNotEquals(test,result);
    }

    @Test
    void findAllUsers() {
        List<User> result = userService.findAllUsers();
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void get() {
        User test = userService.get(3);
        Optional<User> result = Optional.of(userRepository.getById(3));
        Assertions.assertNotEquals(test,result);

    }
}