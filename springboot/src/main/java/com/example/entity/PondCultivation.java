package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "pondcultivation")
public class PondCultivation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pondId")
    private Integer pondId;

    @Column(name = "personId")
    private Integer personId;

    @Transient
    private String PersonName;

    @Transient
    private String fishPondName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPondId() {
        return pondId;
    }

    public void setPondId(Integer pondId) {
        this.pondId = pondId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getFishPondName() {
        return fishPondName;
    }

    public void setFishPondName(String fishPondName) {
        this.fishPondName = fishPondName;
    }
}