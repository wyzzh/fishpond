package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deviceInfo")
public class DeviceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DeviceStatus status;

    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Column(name = "image")
    private String image;

    @Column(name = "deviceId")
    private Integer deviceId;

    @Column(name = "pondId")
    private Integer pondId;

    @Transient
    private String deviceTypeNmae;

    @Transient
    private String fishpondName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getPondId() {
        return pondId;
    }

    public void setPondId(Integer pondId) {
        this.pondId = pondId;
    }

    public String getDeviceTypeNmae() {
        return deviceTypeNmae;
    }

    public void setDeviceTypeNmae(String deviceTypeNmae) {
        this.deviceTypeNmae = deviceTypeNmae;
    }

    public String getFishpondName() {
        return fishpondName;
    }

    public void setFishpondName(String fishpondName) {
        this.fishpondName = fishpondName;
    }

    public enum DeviceStatus {
        运行, 停机
    }
}