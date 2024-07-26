package com.example.controller;

import com.example.common.Result;
import com.example.entity.Animal;
import com.example.entity.Cultivation;
import com.example.entity.Device;
import com.example.entity.Params;
import com.example.service.CultivationService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cultivation")
public class CultivationController {
    @Resource
    private CultivationService cultivationService;

    @GetMapping("")
    public Result getCultivation(){
        List<Cultivation> list = cultivationService.getCultivation();
        return Result.success(list);
    }
    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<Cultivation> info=cultivationService.findBysearch(params);
        return Result.success(info);
    }

    @PostMapping("")
    public Result save(@RequestBody Cultivation cultivation){
        if (cultivation.getId()== null){
            cultivationService.add(cultivation);
        }else{
            cultivationService.update(cultivation);
        }
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        cultivationService.detele(id);
        return Result.success();
    }


    @GetMapping("/cultivationTotal")
    public Result getcultivationTotal() {
        int total = cultivationService.getcultivationTotal();
        return Result.success(total);
    }
}
