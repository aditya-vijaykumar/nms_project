package com.fullstackdevdevice.device;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstackdevdevice.device.model.NetworkService;
import com.fullstackdevdevice.device.repository.NetworkServiceRepository;

@RestController
@RequestMapping(value = "/network_services")
public class NetworkServiceController {
  
  private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final NetworkServiceRepository networkRepository;

  public NetworkServiceController(NetworkServiceRepository networkRepository) {
		this.networkRepository = networkRepository;
	}

	@GetMapping()
	public List<NetworkService> getAllNetworkServices() {
		LOG.info("Getting all networks.");
		return networkRepository.findAll();
	}

	@PostMapping("/create")
	public NetworkService addNewNetworkServices(@RequestBody NetworkService networkService) {
		LOG.info("Saving connection.");
		return networkRepository.save(networkService);
	}

	@PostMapping("/delete/{connectionId}")
	public boolean deleteNetworkService(@PathVariable String networkServiceId) {
		LOG.info("Saving connection.");
		networkRepository.deleteById(
			networkServiceId
		);
		return true;
	}
}
