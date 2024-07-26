package com.example.dao;

import com.example.entity.Fishpond;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Repository
public interface FishpondDao extends Mapper<Fishpond> {


    List<Fishpond> findBysearch(@Param("params") Params params);

    @Select("SELECT COUNT(*) AS total FROM fishpond")
    int getFishpondTotal();

    @Select("SELECT * FROM fishpond WHERE name = #{name} LIMIT 1")
    Fishpond findByName(@Param("name") String name);
}
