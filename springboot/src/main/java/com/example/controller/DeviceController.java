package com.example.controller;

import com.example.common.Result;
import com.example.entity.Device;
import com.example.entity.Params;
import com.example.service.DeviceService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/device")
public class DeviceController {
    @Resource
    private DeviceService deviceService;



    @GetMapping("")
    public Result getDevice(){
        List<Device> list = deviceService.getDevice();
        return Result.success(list);
    }
    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<Device> info=deviceService.findBysearch(params);
        return Result.success(info);
    }
    @PostMapping("")
    public Result save(@RequestBody Device device){
        if (device.getId()== null){
            deviceService.add(device);
        }else{
            deviceService.update(device);
        }
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        deviceService.detele(id);
        return Result.success();
    }
}
