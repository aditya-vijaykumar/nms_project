package com.fullstackdevdevice.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.ConnectionNode;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.DeviceNode;
import com.fullstackdevdevice.controller.model.NetworkService;

public class Graph {
  private Map<String, Device> devices;
  private DeviceClient deviceClient;

  public Graph(DeviceClient deviceClient) {
    this.devices = new HashMap<String, Device>();
    this.deviceClient = deviceClient;
    List<Device> devices = this.deviceClient .getAllDevices();
    List<NetworkService> networkServices = deviceClient.getAllNetworkServices();
    List<Connection> connections = deviceClient.getAllConnections();
    for (Device device : devices) {
      this.devices.put(device.getName(), device);
    }
    for (Connection connection : connections) {
      DeviceNode startDevice = (DeviceNode) this.devices.get(connection.getSourceDeviceId());
      Device endDevice = (DeviceNode) this.devices.get(connection.getDestinationDeviceId());
      startDevice.addConnection((DeviceNode) endDevice, 1);
    }
  }

  public List<DeviceNode> findShortestPath(String startDeviceName, String endDeviceName) {
    Map<DeviceNode, Integer> distance = new HashMap<>();
    Map<DeviceNode, DeviceNode> predecessor = new HashMap<>();
    PriorityQueue<DeviceNode> queue = new PriorityQueue<>((o1, o2) -> distance.get(o1) - distance.get(o2));
    for (Device device : devices.values()) {
      distance.put((DeviceNode) device, Integer.MAX_VALUE);
    }
    distance.replace((DeviceNode) devices.get(startDeviceName), 0);
    queue.offer((DeviceNode) devices.get(startDeviceName));
    while (!queue.isEmpty()) {
      DeviceNode current = queue.poll();
      for (ConnectionNode connection : current.getConnections()) {
        DeviceNode neighbor = connection.getEndDevice();
        int newDistance = distance.get(current) + connection.getWeight();
        if (newDistance < distance.get(neighbor)) {
          distance.replace(neighbor, newDistance);
          predecessor.put(neighbor, current);
          queue.offer(neighbor);
        }
      }
    }
    List<DeviceNode> path = new LinkedList<>();
    DeviceNode current = (DeviceNode) devices.get(endDeviceName);
    while (current != null) {
      ((LinkedList<DeviceNode>) path).addFirst(current);
      current = predecessor.get(current);
    }
    return path;
  }
}
