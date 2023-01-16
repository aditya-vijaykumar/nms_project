package com.fullstackdevdevice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.NetworkService;

@Component
public class DeviceClient {
  private final RestTemplate restTemplate;
  private final List<String> deviceServerUrls;

  public DeviceClient(RestTemplate restTemplate, @Value("${device.server.urls}") List<String> deviceServerUrls) {
    this.restTemplate = restTemplate;
    this.deviceServerUrls = deviceServerUrls;
  }

  public List<Device> getAllDevices() {
    List<Device> devices = new ArrayList<>();
    for (String deviceServerUrl : deviceServerUrls) {
      devices.addAll(restTemplate.getForObject(deviceServerUrl + "/devices", List.class));
    }
    return devices;
  }

  public List<NetworkService> getAllNetworkServices() {
    List<NetworkService> networkServices = new ArrayList<>();
    for (String deviceServerUrl : deviceServerUrls) {
      networkServices.addAll(restTemplate.getForObject(deviceServerUrl + "/network_services", List.class));
    }
    return networkServices;
  }

  public List<Connection> getAllConnections() {
    List<Connection> connections = new ArrayList<>();
    for (String deviceServerUrl : deviceServerUrls) {
      connections.addAll(restTemplate.getForObject(deviceServerUrl + "/connections", List.class));
    }
    return connections;
  }
}
