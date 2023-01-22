package com.fullstackdevdevice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevdevice.controller.model.Alarm;
import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.NetworkService;


@RestController
@RequestMapping(value = "/api")
public class AccessPointController {
  
  private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final DeviceClient deviceClient;
	private final Graph graph;

  public AccessPointController(DeviceClient deviceClient,  Graph graph) {
		this.deviceClient = deviceClient;
		this.graph = graph;
	}

	@GetMapping("/devices")
	public List<Device> getAllDevices() {
		LOG.info("Getting all devices.");
		return deviceClient.getAllDevices();
	}

  @GetMapping("/connections")
	public List<Connection> getAllConnections() {
		LOG.info("Getting all connections.");
		return deviceClient.getAllConnections();
	}

  @GetMapping("/network-services")
	public List<NetworkService> getAllNetworkServices() {
		LOG.info("Getting all network services.");
		return deviceClient.getAllNetworkServices();
	}

	@GetMapping("/all-alarms")
	public List<Alarm> getAllAlarms() {
		LOG.info("Getting all network services.");
		return deviceClient.getAllAlarms();
	}

	@GetMapping("/alarms")
	public List<Alarm> getAllUnacknowledgedAlarms() {
		LOG.info("Getting all network services.");
		return deviceClient.getAllUnacknowledgedAlarms();
	}

  @PostMapping("/new-connection")
	public ResponseEntity<Map<String, Object>> addNewDeviceServer(@RequestBody String startDeviceName) {
		LOG.info("Find shortest path.");
		Map<String, Object> data = new HashMap<>();
		data.put("path", graph.findShortestPath("Device A", "Device D"));
		return new ResponseEntity<>(data, HttpStatus.OK);
	}

}
