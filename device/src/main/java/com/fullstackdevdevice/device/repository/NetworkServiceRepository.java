
package com.fullstackdevdevice.device.repository;
// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.mongodb.repository.Query;

import com.fullstackdevdevice.device.model.NetworkService;

public interface NetworkServiceRepository extends MongoRepository<NetworkService, String> {
  
}
