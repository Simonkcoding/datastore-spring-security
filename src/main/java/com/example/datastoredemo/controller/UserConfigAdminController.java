package com.example.datastoredemo.controller;

import com.example.datastoredemo.model.UserConfig;
import com.example.datastoredemo.repository.UserConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class UserConfigAdminController {
    @Autowired
    UserConfigRepository repo;

    @GetMapping("/user")
    public String user(){
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping
    public Iterable<UserConfig> getAllConfig(){
        return repo.findAll();
    }

    @GetMapping("/{userName}")
    public UserConfig getConfigByKey(@PathVariable String userName){
        return  repo.findByUserName(userName);
    }

    @PostMapping
    public UserConfig createConfig(@RequestBody UserConfig config){
        return repo.save(config);
    }

}
