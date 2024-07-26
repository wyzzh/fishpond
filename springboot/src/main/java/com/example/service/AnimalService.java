package com.example.service;

import com.example.dao.AnimalDao;
import com.example.entity.Animal;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AnimalService {
    @Resource
    private AnimalDao animalDao;

    public List<Animal> getAnimal() {
        return animalDao.selectAll();
    }

    public PageInfo<Animal> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),5);
        List<Animal> list = animalDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public void add(Animal animal) {
        animalDao.insertSelective(animal);
    }

    public void update(Animal animal) {
        animalDao.updateByPrimaryKeySelective(animal);
    }

    public void detele(Integer id) {
        animalDao.deleteByPrimaryKey(id);
    }




    public int getanimalTotal() {
        return animalDao.getanimalTotal();
    }
}
