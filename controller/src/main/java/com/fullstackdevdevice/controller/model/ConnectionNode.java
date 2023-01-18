package com.fullstackdevdevice.controller.model;

public class ConnectionNode {
  private DeviceNode endDevice;
  private int weight;
  public ConnectionNode(DeviceNode endDevice, int weight) {
      this.endDevice = endDevice;
      this.weight = weight;
  }
  //getters and setters

  public DeviceNode getEndDevice() {
    return endDevice;
  }

  public void setEndDevice(DeviceNode endDevice) {
    this.endDevice = endDevice;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
}
