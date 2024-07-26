package com.example.entity;

import cn.hutool.core.annotation.Alias;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Alias("名字")
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Alias("性别")
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @Alias("身份证号")
    @Column(name = "idNumber", unique = true)
    private String idNumber;

    @Alias("学历")
    @Column(name = "education")
    private String education;

    @Alias("岗位")
    @Column(name = "position")
    private String position;

    @Alias("技能")
    @Lob
    @Column(name = "skills")
    private String skills;

    @Alias("入职时间")
    @Temporal(TemporalType.DATE)
    @Column(name = "hireDate")
    private Date hireDate;

    @Column(name = "photo")
    private String photo;

    @Transient
    private String token;

    public enum Sex {
        女, 男
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}