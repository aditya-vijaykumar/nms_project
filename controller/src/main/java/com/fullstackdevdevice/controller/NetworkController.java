package com.fullstackdevdevice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/discover")
public class NetworkController {
  private final DeviceClient deviceClient;

  public NetworkController(DeviceClient deviceClient) {
    this.deviceClient = deviceClient;
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> discover() {
    Map<String, Object> data = new HashMap<>();
    data.put("devices", deviceClient.getAllDevices());
    data.put("services", deviceClient.getAllNetworkServices());
    data.put("connections", deviceClient.getAllConnections());
    return new ResponseEntity<>(data, HttpStatus.OK);
  }
}
