package com.fullstackdevdevice.device;

import org.apache.logging.log4j.util.ProviderUtil;
import org.springframework.stereotype.Service;

import com.fullstackdevdevice.device.model.Device;
import com.fullstackdevdevice.device.repository.DeviceRepository;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }
    public long getCount() {
        return deviceRepository.count();
    }
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void checkIfDeviceInfoExistsOrSave() {
        long count = this.getCount();
        if(count < 1) {
            Device dev = new Device("Device A", "IoT", "BLR", "127.0.0.1", "AB:AB:AB:AB", "v1");
            this.saveDevice(dev);
        }
    }

    public void initialize() {
        
    }
}
