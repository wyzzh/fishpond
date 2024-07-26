package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "releaseTime", nullable = false)
    private Date releaseTime;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Integer getFishpondId() {
        return fishpondId;
    }

    public void setFishpondId(Integer fishpondId) {
        this.fishpondId = fishpondId;
    }

    public String getFishPondName() {
        return fishPondName;
    }

    public void setFishPondName(String fishPondName) {
        this.fishPondName = fishPondName;
    }
}