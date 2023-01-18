package com.fullstackdevdevice.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DeviceApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DeviceApplication.class, args);
		DeviceService deviceService= context.getBean(DeviceService.class);
		deviceService.checkIfDeviceInfoExistsOrSave();
	}
}
