package com.fullstackdevdevice.controller.repository;

// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

import com.fullstackdevdevice.controller.model.DeviceServer;


public interface DeviceServerRepository extends MongoRepository<DeviceServer, String> {
  
}
