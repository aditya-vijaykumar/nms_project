package com.fullstackdevdevice.device;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.fullstackdevdevice.device.model.Alarm;
import com.fullstackdevdevice.device.repository.AlarmRepository;

@RestController
@RequestMapping(value = "/alarm")
public class AlarmController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	private final AlarmRepository alarmRepository;

	public AlarmController(AlarmRepository alarmRepository) {
		this.alarmRepository = alarmRepository;
	}

	@GetMapping("/")
	public List<Alarm> getAllAlarms() {
		LOG.info("Getting all alarms.");
		return alarmRepository.findAll();
	}

	@GetMapping("/{alarmId}")
	public Optional<Alarm> geAlarm(@PathVariable String alarmId) {
		LOG.info("Getting alarm with ID: {}.", alarmId);
		return alarmRepository.findById(alarmId);
	}

	@PostMapping("/create")
	public Alarm addNewAlarms(@RequestBody Alarm alarm) {
		LOG.info("Saving alarm.");
		return alarmRepository.save(alarm);
	}

	@GetMapping("/valid")
	public List<Alarm> getAllUnacknowledgedAlarms() {
		LOG.info("Getting all alarms.");
		return alarmRepository.findAllNotAcknowledged();
	}

	@PostMapping("/acknowledged/{alarmId}")
	public String acknowledgeAlarm(@PathVariable String alarmId) {
		Optional<Alarm> optionalAlarm = alarmRepository.findById(alarmId);
		Alarm alarm = optionalAlarm.get();
		if (alarm != null) {
			alarm.setAcknowledged(true);
			alarm.setAcknowledgedTime(new Date());
			alarmRepository.save(alarm);
			return "Acknowledged the alarm";
		} else {
			return "Alarm not found.";
		}
	}

}
