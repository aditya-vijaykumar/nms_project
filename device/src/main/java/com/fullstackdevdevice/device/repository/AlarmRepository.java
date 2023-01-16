package com.fullstackdevdevice.device.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.fullstackdevdevice.device.model.Alarm;


public interface AlarmRepository extends MongoRepository<Alarm, String> {

  
  @Query(value="{acknowledged: 'false'}")
  List<Alarm> findAllNotAcknowledged();
  
}
