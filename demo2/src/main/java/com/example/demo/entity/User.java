package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {


    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private Integer userId;

    @Column
    private String username;


    @Column
    private String title;


    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate time_created;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate last_updated;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;




    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "owner")
    Set<Project> projectSet = new HashSet<>();



    public User(String user_name, String title, Role role, LocalDate time_created, LocalDate last_updated, String password, Integer userId) {
        this.username = user_name;
        this.title = title;
        this.role = role;
        this.time_created = time_created;
        this.last_updated = last_updated;
        this.password = password;
    }

    public User() {

    }

    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<Project> getSet() {
        return projectSet;
    }

    public void setSet(Set<Project> set) {
        this.projectSet = set;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String user_name) {
        this.username = user_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Role getRole() {
        return role;
    }

    public LocalDate getTime_created() {
        return time_created;
    }

    public void setTime_created(LocalDate time_created) {
        this.time_created = time_created;
    }

    public LocalDate getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDate last_updated) {
        this.last_updated = last_updated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
