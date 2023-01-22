package com.fullstackdevdevice.device;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.util.ProviderUtil;
import org.springframework.stereotype.Service;

import com.fullstackdevdevice.device.model.Alarm;
import com.fullstackdevdevice.device.model.Connection;
import com.fullstackdevdevice.device.model.Device;
import com.fullstackdevdevice.device.model.NetworkService;
import com.fullstackdevdevice.device.repository.AlarmRepository;
import com.fullstackdevdevice.device.repository.ConnectionRepository;
import com.fullstackdevdevice.device.repository.DeviceRepository;
import com.fullstackdevdevice.device.repository.NetworkServiceRepository;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;
    private final ConnectionRepository connectionRepository;
    private final NetworkServiceRepository networkRepository;
    private final AlarmRepository alarmRepository;

    public DeviceService(DeviceRepository deviceRepository, ConnectionRepository connectionRepository,
            NetworkServiceRepository networkRepository, AlarmRepository alarmRepository) {
        this.deviceRepository = deviceRepository;
        this.connectionRepository = connectionRepository;
        this.networkRepository = networkRepository;
        this.alarmRepository = alarmRepository;
    }

    public long getCount() {
        return deviceRepository.count();
    }

    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public void initialize() {
        this.connectionRepository.save(new Connection("Device A", "Device B"));
        this.connectionRepository.save(new Connection("Device A", "Device C"));

        List<String> path1 = new ArrayList<String>();
        path1.add("Device A");
        path1.add("Device B");
        Map<String, String> properties1 = new HashMap<String, String>();
        this.networkRepository.save(new NetworkService("Service 1", "Device A", "Device B", path1, properties1));

        List<String> path2 = new ArrayList<String>();
        path2.add("Device A");
        path2.add("Device B");
        path2.add("Device C");
        path2.add("Device D");
        Map<String, String> properties2 = new HashMap<String, String>();
        this.networkRepository.save(new NetworkService("Service 2", "Device A", "Device D", path2, properties2));

        this.alarmRepository.save(new Alarm("Device A", "Service 1", null, null, "Critical", false, new Date(), null));
    }

    public void checkIfDeviceInfoExistsOrSave() {
        long count = this.getCount();
        if (count < 1) {
            Device dev = new Device("Device A", "IoT", "Bagalur, BLR", "127.0.0.1:9090", "10:1B:44:11:3A:B7", "v1");
            this.saveDevice(dev);

            //add some values;
            initialize();
        }
    }
}
