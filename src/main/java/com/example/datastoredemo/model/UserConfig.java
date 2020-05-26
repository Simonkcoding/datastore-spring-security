package com.example.datastoredemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

@Data
@Entity(name = "userConfig")
@AllArgsConstructor
public class UserConfig {
    @Id
    Long id;

    String userName;

    String password;

    boolean isActive;

    String roles;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}
