package com.fullstackdevdevice.device.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "network_services")
public class NetworkService {
    @Id
    private String id;
    private String name;
    private String startDeviceId;
    private String endDeviceId;
    private List<String> path;
    private Map<String, String> properties;

    public NetworkService() {
    }

    public NetworkService(String name, String startDeviceId, String endDeviceId, List<String> path, Map<String, String> properties) {
        this.name = name;
        this.startDeviceId = startDeviceId;
        this.endDeviceId = endDeviceId;
        this.path = path;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDeviceId() {
        return startDeviceId;
    }

    public void setStartDeviceId(String startDeviceId) {
        this.startDeviceId = startDeviceId;
    }

    public String getEndDeviceId() {
        return endDeviceId; 
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}