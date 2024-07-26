package com.example.service;

import com.example.dao.DeviceInfoDao;
import com.example.entity.DeviceInfo;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceInfoService {
    @Resource
    private DeviceInfoDao deviceInfoDao;

    public List<DeviceInfo> getDeviceInfo() {
        return deviceInfoDao.selectAll();
    }

    public PageInfo<DeviceInfo> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),3);
        List<DeviceInfo> list = deviceInfoDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public void add(DeviceInfo deviceInfo) {
        deviceInfoDao.insertSelective(deviceInfo);
    }

    public void update(DeviceInfo deviceInfo) {
        deviceInfoDao.updateByPrimaryKeySelective(deviceInfo);
    }

    public void detele(Integer id) {
        deviceInfoDao.deleteByPrimaryKey(id);
    }

    public int getDeviceInfoTotal() {
        return deviceInfoDao.getDeviceInfoTotal();
    }
}
