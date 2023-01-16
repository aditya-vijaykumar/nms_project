package com.fullstackdevdevice.device.repository;
// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

import com.fullstackdevdevice.device.model.Device;


public interface DeviceRepository extends MongoRepository<Device, String> {
  
}
