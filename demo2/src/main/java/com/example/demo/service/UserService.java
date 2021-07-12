package com.example.demo.service;

import com.example.demo.entity.User;

import java.security.Principal;
import java.util.List;
public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
    List<User> findAllUsers();
    public boolean create(User user);
    /*public boolean delete(String user);*/

    User get(Principal userId);

    User get(Integer userId);

    public boolean update(Integer userId, User user);
    public void clear();
}
