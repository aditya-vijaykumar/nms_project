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

import com.fullstackdevdevice.device.model.Connection;
import com.fullstackdevdevice.device.repository.ConnectionRepository;

@RestController
@RequestMapping(value = "/connection")
public class ConnectionController {
  
  private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final ConnectionRepository connectionRepository;

  public ConnectionController(ConnectionRepository connectionRepository) {
		this.connectionRepository = connectionRepository;
	}

	@GetMapping()
	public List<Connection> getAllConnections() {
		LOG.info("Getting all connections.");
		return connectionRepository.findAll();
	}

	@PostMapping("/create")
	public Connection addNewConnections(@RequestBody Connection conn) {
		LOG.info("Saving connection.");
		return connectionRepository.save(conn);
	}

	@PostMapping("/delete/${connectionId}")
	public boolean deleteConnection(@PathVariable String connectionId) {
		LOG.info("Saving connection.");
		connectionRepository.deleteById(
			connectionId
		);
		return true;
	}
}
