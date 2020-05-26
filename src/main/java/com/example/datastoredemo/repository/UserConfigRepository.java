package com.example.datastoredemo.repository;

import com.example.datastoredemo.model.UserConfig;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface UserConfigRepository extends DatastoreRepository<UserConfig, Long> {
  UserConfig findByUserName(String userName);
}
