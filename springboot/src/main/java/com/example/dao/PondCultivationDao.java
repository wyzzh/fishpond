package com.example.dao;

import com.example.entity.Params;
import com.example.entity.PondCultivation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface PondCultivationDao extends Mapper<PondCultivation> {
    List<PondCultivation> findBysearch(@Param("params") Params params);
}
