package com.fullstackdevdevice.controller.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "devices")
public class Device {
  @Id
  protected String id;
  protected String name;
  protected String type;
  protected String location;
  protected String ip;
  protected String mac;
  protected String version;
  protected Map<String, String> properties;
  protected List<String> services;
  protected List<String> signals;

  public Device(String name, String type, String location, String ip, String mac, String version) {
    this.name = name;
    this.type = type;
    this.location = location;
    this.ip = ip;
    this.mac = mac;
    this.version = version;
    this.services = new ArrayList<>();
    this.signals = new ArrayList<>();
    this.properties = new HashMap<>();
  }

  public Device() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public String getMac() {
    return mac;
  }

  public void setMac(String mac) {
    this.mac = mac;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  public List<String> getServices() {
    return services;
  }

  public void setServices(List<String> services) {
    this.services = services;
  }

  public List<String> getSignals() {
    return signals;
  }

  public void setSignals(List<String> signals) {
    this.signals = signals;
  }

}