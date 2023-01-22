package com.fullstackdevdevice.device;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevdevice.device.model.Device;
import com.fullstackdevdevice.device.repository.DeviceRepository;

@RestController
@RequestMapping(value = "/devices")
public class DeviceController {
  
  private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final DeviceRepository deviceRepository;

  public DeviceController(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@GetMapping()
	public List<Device> getDeviceDetails() {
		LOG.info("Getting device details.");
		return deviceRepository.findAll();
	}
}
