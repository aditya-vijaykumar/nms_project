package com.fullstackdevdevice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevdevice.controller.model.DeviceServer;


@RestController
@RequestMapping(value = "/device-server")
public class DeviceServerController {
  
  private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final DeviceServerService deviceServerService;

  public DeviceServerController(DeviceServerService deviceServerService) {
		this.deviceServerService = deviceServerService;
	}

	@GetMapping()
	public List<DeviceServer> getAllConnections() {
		LOG.info("Getting all devices.");
		return deviceServerService.getAll();
	}

	@PostMapping("/create")
	public DeviceServer addNewDeviceServer(@RequestBody DeviceServer device) {
		LOG.info("Saving a new device.");
		return deviceServerService.saveDeviceServer(device);
	}

	@PostMapping("/delete/{deviceId}")
	public boolean deleteDeviceServer(@PathVariable String deviceId) {
		LOG.info("Saving connection.");
		deviceServerService.deleteDeviceServerById(
			deviceId
		);
		return true;
	}
}
