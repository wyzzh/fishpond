package com.example.service;

import com.example.dao.DeviceDao;
import com.example.entity.Device;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeviceService {
    @Resource
    private DeviceDao deviceDao;

    public List<Device> getDevice() {
        return deviceDao.selectAll();
    }

    public PageInfo<Device> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),3);
        List<Device> list = deviceDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public void add(Device device) {
        deviceDao.insertSelective(device);
    }

    public void update(Device device) {
        deviceDao.updateByPrimaryKeySelective(device);
    }

    public void detele(Integer id) {
        deviceDao.deleteByPrimaryKey(id);
    }


}
