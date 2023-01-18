package com.fullstackdevdevice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevdevice.controller.model.Connection;
import com.fullstackdevdevice.controller.model.Device;
import com.fullstackdevdevice.controller.model.DeviceNode;
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

  @PostMapping("/new-connection")
	public List<DeviceNode> addNewDeviceServer(@RequestBody String startDeviceName, @RequestBody String endDeviceName) {
		LOG.info("Find shortest path.");
		return graph.findShortestPath(startDeviceName, endDeviceName);
	}

}
