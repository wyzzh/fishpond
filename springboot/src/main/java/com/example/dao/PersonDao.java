package com.example.dao;

import com.example.entity.Params;
import com.example.entity.Person;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PersonDao extends Mapper<Person>{

    List<Person> findBysearch(@Param("params") Params params);

    @Select("select * from person")
    List<Person> getPerson();

    @Select("select name,sex,idNumber,education,position,skills,hireDate from person")
    List<Person> findAll();

    @Select("SELECT COUNT(*) AS total FROM person")
    int getPersonTotal();

    @Select("select * from person where name=#{name} limit 1")
    Person findByName(@Param("name")String name);

    @Select("select * from person where name=#{name}  and password=#{password} limit 1")
    Person findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
