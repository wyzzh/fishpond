package com.example.controller;

import com.example.common.Result;
import com.example.entity.Cultivation;
import com.example.entity.Params;
import com.example.entity.PondCultivation;
import com.example.service.PondCultivationService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/pondCultivation")
public class PondCultivationController {
    @Resource
    private PondCultivationService pondCultivationService;

    @GetMapping("")
    public Result findBySearch(Params params){
        PageInfo<PondCultivation> info=pondCultivationService.findBysearch(params);
        return Result.success(info);
    }
    @PostMapping("")
    public Result save(@RequestBody PondCultivation pondCultivation){
        if (pondCultivation.getId()== null){
            pondCultivationService.add(pondCultivation);
        }else{
            pondCultivationService.update(pondCultivation);
        }
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        pondCultivationService.detele(id);
        return Result.success();
    }
}
