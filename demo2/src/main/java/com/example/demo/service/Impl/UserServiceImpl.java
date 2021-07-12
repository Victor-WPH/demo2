package com.example.demo.service.Impl;


import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private PasswordEncoder passwordEncoder;

        @Override
        public User saveUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

        @Override
        public User findByUsername(String username) {
            return userRepository.findByUsername(username);
        }

        @Override
        public List<User> findAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public boolean create(User user) {
            try {
                userRepository.save(user);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }

        /*@Override
        @Transactional
        public boolean delete(String user) {
            if (user == null) {
                return false;
            }
            System.out.println("deleting user");
            userRepository.deleteById(user);
            return true;
        }*/

    @Override
    public User get(Principal userId) {
        return null;
    }




    @Override
        public User get(Integer userId) {
            Optional<User> a = userRepository.findById(userId);
            if (a.isPresent()) {
                return a.get();
            }
            return null;
        }


        @Override
        public boolean update(Integer userId, User user) {
            Optional<User> toUpdate = userRepository.findById(userId);
            if (toUpdate.isPresent()) {
                User newUser = toUpdate.get();
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
                try {
                    userRepository.save(newUser);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override
        public void clear() {
            userRepository.deleteAll();
        }
    }


