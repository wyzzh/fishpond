package com.example.dao;

import com.example.entity.DeviceInfo;
import com.example.entity.Params;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

@Repository
public interface DeviceInfoDao extends Mapper<DeviceInfo> {

    List<DeviceInfo> findBysearch(@Param("params") Params params);

    @Select("SELECT COUNT(*) AS total FROM deviceinfo")
    int getDeviceInfoTotal();
}
