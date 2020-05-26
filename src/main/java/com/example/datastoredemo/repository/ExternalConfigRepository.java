package com.example.datastoredemo.repository;

import com.example.datastoredemo.model.ExternalConfig;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface ExternalConfigRepository extends DatastoreRepository<ExternalConfig, Long> {
    ExternalConfig findByVariableKey(String key);
}
