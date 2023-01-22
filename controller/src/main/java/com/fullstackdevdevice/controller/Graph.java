package com.fullstackdevdevice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.ConnectionNode;
import com.fullstackdevdevice.controller.model.DeviceNode;
import com.fullstackdevdevice.controller.model.DeviceServer;
import com.fullstackdevdevice.controller.model.NetworkService;

@Component
public class Graph {
  private Map<String, DeviceNode> devices;
  private final DeviceServerService deviceServerService;
  private final DeviceClient deviceClient;

  public Graph(DeviceServerService deviceServerService,  DeviceClient deviceClient) {
    this.devices = new HashMap<String, DeviceNode>();
    this.deviceServerService = deviceServerService;
    this.deviceClient = deviceClient;
  }

  public List<DeviceNode> getAllDevices() {
    RestTemplate restTemplate = new RestTemplate();
    List<DeviceNode> devices = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<DeviceNode>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() + "/devices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<DeviceNode>>() {}
      );
      devices.addAll(responseEntity.getBody());
    }
    return devices;
  }

  public void initialize() {
    List<DeviceNode> devices = this.getAllDevices();
    List<NetworkService> networkServices = deviceClient.getAllNetworkServices();
    List<Connection> connections = deviceClient.getAllConnections();
    for (DeviceNode device : devices) {
      this.devices.put(device.getName(), device);
    }
    for (Connection connection : connections) {
      DeviceNode startDevice = this.devices.get(connection.getSourceDeviceId());
      DeviceNode endDevice = this.devices.get(connection.getDestinationDeviceId());
      startDevice.addConnection(endDevice, 1);
    }
  }

  public List<String> findShortestPath(String startDeviceName, String endDeviceName) {
    this.initialize();
    Map<DeviceNode, Integer> distance = new HashMap<>();
    Map<DeviceNode, DeviceNode> predecessor = new HashMap<>();
    PriorityQueue<DeviceNode> queue = new PriorityQueue<>((o1, o2) -> distance.get(o1) - distance.get(o2));
    for (DeviceNode device : devices.values()) {
      distance.put( device, Integer.MAX_VALUE);
    }
    distance.replace(devices.get(startDeviceName), 0);
    queue.offer(devices.get(startDeviceName));
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
    List<String> pathAsString = new ArrayList<>();
    path.forEach((v) -> {
      pathAsString.add(v.getName());
    });
    return pathAsString;
  }
}
