package com.fullstackdevdevice.controller.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connections")
public class Connection {
    @Id
    private String id;
    private String sourceDeviceId;
    private String destinationDeviceId;
    
    public Connection() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceDeviceId() {
        return sourceDeviceId;
    }

    public void setSourceDeviceId(String sourceDeviceId) {
        this.sourceDeviceId = sourceDeviceId;
    }

    public String getDestinationDeviceId() {
        return destinationDeviceId;
    }

    public void setDestinationDeviceId(String destinationDeviceId) {
        this.destinationDeviceId = destinationDeviceId;
    }

}
