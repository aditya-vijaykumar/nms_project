package com.fullstackdevdevice.controller.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DeviceNode extends Device {
  private List<ConnectionNode> connections;
  
  public DeviceNode(String name) {
      this.connections = new ArrayList<>();
  }

  public DeviceNode(String name, String type, String location, String ip, String mac, String version) {
    this.name = name;
    this.type = type;
    this.location = location;
    this.ip = ip;
    this.mac = mac;
    this.version = version;
    this.services = new ArrayList<>();
    this.signals = new ArrayList<>();
    this.properties = new HashMap<>();
    this.connections = new ArrayList<>();
  }

  public void addConnection(DeviceNode device, int weight) {
      this.connections.add(new ConnectionNode(device, weight));
  }
  // other methods

  public List<ConnectionNode> getConnections() {
    return connections;
  }

}
