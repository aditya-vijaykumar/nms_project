package com.fullstackdevdevice.controller.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document("alarms")
public class Alarm {

  @Id
  private String id;
  private String deviceId;
  private String serviceId;
  private String alarmSeverity;
  private boolean acknowledged;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
  private Date raisedTime;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
  private Date acknowledgedTime;

  public Alarm(String deviceId, String serviceId, String alarmSeverity,
      boolean acknowledged, Date raisedTime, Date acknowledgedTime) {
    super();
    this.deviceId = deviceId;
    this.serviceId = serviceId;
    this.alarmSeverity = alarmSeverity;
    this.acknowledged = acknowledged;
    this.raisedTime = raisedTime;
    if(acknowledgedTime != null) {
      this.acknowledgedTime = acknowledgedTime;
    }
  }

  public Alarm() {
    
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDeviceId() {
    return deviceId;
  }

  public void setDeviceId(String deviceId) {
    this.deviceId = deviceId;
  }

  public String getServiceId() {
    return serviceId;
  }

  public void setServiceId(String serviceId) {
    this.serviceId = serviceId;
  }

  public String getAlarmSeverity() {
    return alarmSeverity;
  }

  public void setAlarmSeverity(String alarmSeverity) {
    this.alarmSeverity = alarmSeverity;
  }

  public boolean getAcknowledged() {
    return acknowledged;
  }

  public void setAcknowledged(Boolean acknowledged) {
    this.acknowledged = acknowledged;
  }

  public Date getRaisedTime() {
   return raisedTime;
  }

  public void setRaisedTime(Date raisedTime) {
    this.raisedTime = raisedTime;
  }

  public Date getAcknowledgedTime() {
    return acknowledgedTime;
  }

  public void setAcknowledgedTime(Date acknowledgedTime) {
    this.acknowledgedTime = acknowledgedTime;
  }

}