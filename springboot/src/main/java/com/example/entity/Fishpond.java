package com.example.entity;
import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "fishpond")
public class Fishpond {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "area", nullable = false)
    private BigDecimal area;

    @Column(name = "depth", nullable = false)
    private BigDecimal depth;

    @Column(name = "soil")
    private String soil;

    @Column(name = "bottom")
    private String bottom;

    @Column(name = "image")
    private String image;

    @Column(name = "position")
    private String position;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public String getSoil() {
        return soil;
    }

    public void setSoil(String soil) {
        this.soil= soil;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


}