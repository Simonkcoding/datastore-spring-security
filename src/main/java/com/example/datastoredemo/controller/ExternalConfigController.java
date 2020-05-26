package com.example.datastoredemo.controller;


import com.example.datastoredemo.model.ExternalConfig;
import com.example.datastoredemo.service.ExternalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class ExternalConfigController {
    @Autowired
    ExternalConfigService service;

    @GetMapping
    public Iterable<ExternalConfig> getAllConfig() {
        return service.getAllConfig();
    }

    @GetMapping("/{variableKey}")
    public ExternalConfig getConfigByKey(@PathVariable String variableKey) {
        return service.getConfigByKey(variableKey);
    }

    @PostMapping
    public ExternalConfig createConfig(@RequestBody ExternalConfig config) {
        return service.createConfig(config);
    }

    @PutMapping("/{variableKey}")
    public ExternalConfig updateConfig(@PathVariable String variableKey,
                                       @RequestBody ExternalConfig config) {
        return service.updateConfig(variableKey, config);
    }

    @DeleteMapping("/{variableKey}")
    public void deleteConfig(@PathVariable String variableKey) {
        service.deleteConfig(variableKey);
    }
}
