package com.fullstackdevdevice.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fullstackdevdevice.controller.repository.DeviceServerRepository;
import com.fullstackdevdevice.controller.model.DeviceServer;

@Service
public class DeviceServerService {
    private final DeviceServerRepository deviceServerRepository;
    public DeviceServerService(DeviceServerRepository deviceServerRepository) {
        this.deviceServerRepository = deviceServerRepository;
    }
    public List<DeviceServer> getAll() {
        return deviceServerRepository.findAll();
    }
    public DeviceServer saveDeviceServer(DeviceServer deviceServer) {
        return deviceServerRepository.save(deviceServer);
    }
    public void deleteDeviceServerById(String id) {
        deviceServerRepository.deleteById(id);
    }
}
