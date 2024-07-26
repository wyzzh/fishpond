package com.example.controller;

import com.example.common.Result;
import com.example.entity.Fishpond;
import com.example.entity.Params;
import com.example.service.FishpondService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Fishpond")
public class FishpondController {

    @Resource
    private FishpondService fishpondService;

    @GetMapping("/fishpondTotal")
    public Result getFishpondTotal() {
        int total = fishpondService.getFishpondTotal();
        return Result.success(total);
    }

    @GetMapping("")
    public Result getFishpond(){
        List<Fishpond> list = fishpondService.getFishpond();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<Fishpond> info=fishpondService.findBysearch(params);
        return Result.success(info);
    }

    @PostMapping()
    public Result save(@RequestBody Fishpond fishpond){
        if (fishpond.getId()== null){
            fishpondService.add(fishpond);
        }else{
            fishpondService.update(fishpond);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        fishpondService.detele(id);
        return Result.success();
    }
}
