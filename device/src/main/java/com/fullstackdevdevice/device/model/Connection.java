package com.fullstackdevdevice.device.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "connections")
public class Connection {
    @Id
    private String id;
    private String sourceDevice;
    private String destinationDevice;
    
    public Connection() {}
    public Connection(String sourceDeviceId,String destinationDeviceId ) {
        this.sourceDevice = sourceDeviceId;
        this.destinationDevice = destinationDeviceId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceDeviceId() {
        return sourceDevice;
    }

    public void setSourceDeviceId(String sourceDeviceId) {
        this.sourceDevice = sourceDeviceId;
    }

    public String getDestinationDeviceId() {
        return destinationDevice;
    }

    public void setDestinationDeviceId(String destinationDeviceId) {
        this.destinationDevice = destinationDeviceId;
    }
}
