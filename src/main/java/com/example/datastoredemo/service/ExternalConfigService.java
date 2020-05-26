package com.example.datastoredemo.service;


import com.example.datastoredemo.model.ExternalConfig;
import com.example.datastoredemo.repository.ExternalConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
public class ExternalConfigService {

    @Autowired
    ExternalConfigRepository repo;

    // GET ALL
    public Iterable<ExternalConfig> getAllConfig(){
        return repo.findAll();
    }


    // GET1
    public ExternalConfig getConfigByKey(String variableKey){
        return repo.findByVariableKey(variableKey);
    }

    // POST
    public ExternalConfig createConfig(ExternalConfig config){
        return repo.save(config);
    }

    // UPDATE
    public ExternalConfig updateConfig(String variableKey, ExternalConfig config){
        if (config.getVariableKey().equals(variableKey)){
            return  repo.save(config);
        } else {
            return null;
        }
    }

    // DELETE
    public void deleteConfig(String variableKey){
        long tempId = repo.findByVariableKey(variableKey).getId();
        repo.deleteById(tempId);
    }


}
