package com.fullstackdevdevice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.DeviceServer;
import com.fullstackdevdevice.controller.model.NetworkService;

@Component
public class DeviceClient {
  private final RestTemplate restTemplate;
  private final DeviceServerService deviceServerService;

  public DeviceClient(RestTemplate restTemplate, DeviceServerService deviceServerService) {
    this.restTemplate = restTemplate;
    this.deviceServerService = deviceServerService;
  }

  public List<Device> getAllDevices() {
    List<Device> devices = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      devices.addAll(restTemplate.getForObject(deviceServer.getUrl() + "/devices", List.class));
    }
    return devices;
  }

  public List<NetworkService> getAllNetworkServices() {
    List<NetworkService> networkServices = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      networkServices.addAll(restTemplate.getForObject(deviceServer.getUrl() + "/network_services", List.class));
    }
    return networkServices;
  }

  public List<Connection> getAllConnections() {
    List<Connection> connections = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      connections.addAll(restTemplate.getForObject(deviceServer.getUrl() + "/connections", List.class));
    }
    return connections;
  }
}
