package com.example.dao;

import com.example.entity.Animal;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AnimalDao extends Mapper<Animal> {
    List<Animal> findBysearch(@Param("params") Params params);

    @Select("SELECT COUNT(*) AS total FROM animal")
    int getanimalTotal();
}
