package com.example.controller;

import com.example.common.Result;
import com.example.entity.Animal;
import com.example.entity.Params;
import com.example.service.AnimalService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/animal")
public class AnimalController {
    @Resource
    private AnimalService animalService;


    @GetMapping("/animalTotal")
    public Result getanimalTotal() {
        int total = animalService.getanimalTotal();
        return Result.success(total);
    }

    @GetMapping("")
    public Result getAnimal(){
        List<Animal> list = animalService.getAnimal();
        return Result.success(list);
    }
    @GetMapping("/search")
    public Result findBySearch(Params params){
        PageInfo<Animal> info=animalService.findBysearch(params);
        return Result.success(info);
    }
    @PostMapping("")
    public Result save(@RequestBody Animal animal){
        if (animal.getId()== null){
            animalService.add(animal);
        }else{
            animalService.update(animal);
        }
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        animalService.detele(id);
        return Result.success();
    }

}
