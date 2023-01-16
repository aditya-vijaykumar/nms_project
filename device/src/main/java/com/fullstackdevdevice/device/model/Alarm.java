package com.fullstackdevdevice.device.model;

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
  private String signalId;
  private String alarmMessage;
  private String alarmSeverity;
  private boolean acknowledged;

  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
  private Date raisedTime;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
  private Date acknowledgedTime;

  public Alarm(String deviceId, String serviceId, String signalId, String alarmMessage, String alarmSeverity,
      boolean acknowledged, Date raisedTime, Date acknowledgedTime) {
    super();
    this.deviceId = deviceId;
    this.serviceId = serviceId;
    this.signalId = signalId;
    this.alarmMessage = alarmMessage;
    this.alarmSeverity = alarmSeverity;
    this.acknowledged = acknowledged;
    this.raisedTime = raisedTime;
    this.acknowledgedTime = acknowledgedTime;
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

  public String getSignalId() {
    return signalId;
  }

  public void setSignalId(String signalId) {
    this.signalId = signalId;
  }

  public String getAlarmMessage() {
    return alarmMessage;
  }

  public void setAlarmMessage(String alarmMessage) {
    this.alarmMessage = alarmMessage;
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