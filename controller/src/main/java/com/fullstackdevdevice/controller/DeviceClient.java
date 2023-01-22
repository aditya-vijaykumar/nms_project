package com.fullstackdevdevice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fullstackdevdevice.controller.model.Alarm;
import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.DeviceServer;
import com.fullstackdevdevice.controller.model.NetworkService;

@Component
public class DeviceClient {
  private final DeviceServerService deviceServerService;

  public DeviceClient(DeviceServerService deviceServerService) {
    this.deviceServerService = deviceServerService;
  }

  public List<Device> getAllDevices() {
    RestTemplate restTemplate = new RestTemplate();
    List<Device> devices = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<Device>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() + "/devices",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Device>>() {}
      );
      devices.addAll(responseEntity.getBody());
    }
    return devices;
  }

  public List<NetworkService> getAllNetworkServices() {
    RestTemplate restTemplate = new RestTemplate();
    List<NetworkService> networkServices = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<NetworkService>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() + "/network_services",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<NetworkService>>() {}
      );
      networkServices.addAll(responseEntity.getBody());
    }
    return networkServices;
  }

  public List<Connection> getAllConnections() {
    RestTemplate restTemplate = new RestTemplate();
    List<Connection> connections = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<Connection>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() +  "/connections",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Connection>>() {}
      );
      connections.addAll(responseEntity.getBody());
    }
    return connections;
  }

  public List<Alarm> getAllUnacknowledgedAlarms() {
    RestTemplate restTemplate = new RestTemplate();
    List<Alarm> alarms = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<Alarm>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() + "/alarm/valid",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Alarm>>() {}
      );
      alarms.addAll(responseEntity.getBody());
    }
    return alarms;
  }

  public List<Alarm> getAllAlarms() {
    RestTemplate restTemplate = new RestTemplate();
    List<Alarm> alarms = new ArrayList<>();
    List<DeviceServer> deviceServers = deviceServerService.getAll();
    for (DeviceServer deviceServer : deviceServers) {
      ResponseEntity<List<Alarm>> responseEntity = 
      restTemplate.exchange(
        deviceServer.getUrl() + "/alarm/all",
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<Alarm>>() {}
      );
      alarms.addAll(responseEntity.getBody());
    }
    return alarms;
  }
}
