package com.example.controller;

import com.example.common.Result;
import com.example.entity.Device;
import com.example.entity.DeviceInfo;
import com.example.entity.Params;
import com.example.service.DeviceInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {
    @Resource
    private DeviceInfoService deviceInfoService;

    @GetMapping("")
    public Result getDeviceInfo(){
        List<DeviceInfo> list = deviceInfoService.getDeviceInfo();
        return Result.success(list);
    }
    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<DeviceInfo> info=deviceInfoService.findBysearch(params);
        return Result.success(info);
    }
    @PostMapping("")
    public Result save(@RequestBody DeviceInfo deviceInfo){
        if (deviceInfo.getId()== null){
            deviceInfoService.add(deviceInfo);
        }else{
            deviceInfoService.update(deviceInfo);
        }
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        deviceInfoService.detele(id);
        return Result.success();
    }
    @GetMapping("/deviceInfoTotal")
    public Result getDeviceInfoTotal() {
        int total = deviceInfoService.getDeviceInfoTotal();
        return Result.success(total);
    }
}
