package com.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "cultivation")
public class Cultivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "feedingTime", nullable = false)
    private Date feedingTime;

    @Column(name = "feedingAmount", nullable = false)
    private Integer feedingAmount;

    @Column(name = "feedType", nullable = false)
    private String feedType;

    @Column(name = "fishpondId")
    private Integer fishpondId;

    @Transient
    private String fishPondName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFeedingTime() {
        return feedingTime;
    }

    public void setFeedingTime(Date feedingTime) {
        this.feedingTime = feedingTime;
    }


    public String getFeedType() {
        return feedType;
    }

    public void setFeedType(String feedType) {
        this.feedType = feedType;
    }

    public Integer getFishpondId() {
        return fishpondId;
    }

    public void setFishpondId(Integer fishpondId) {
        this.fishpondId = fishpondId;
    }

    public Integer getFeedingAmount() {
        return feedingAmount;
    }

    public void setFeedingAmount(Integer feedingAmount) {
        this.feedingAmount = feedingAmount;
    }

    public String getFishPondName() {
        return fishPondName;
    }

    public void setFishPondName(String fishPondName) {
        this.fishPondName = fishPondName;
    }
}