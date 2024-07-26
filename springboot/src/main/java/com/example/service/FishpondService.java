package com.example.service;

import com.example.dao.FishpondDao;
import com.example.entity.Fishpond;
import com.example.entity.Params;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FishpondService {
    
    @Resource
    private FishpondDao fishpondDao;

    public List<Fishpond> getFishpond() {
        return fishpondDao.selectAll();
    }

    public PageInfo<Fishpond> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),3);
        List<Fishpond> list = fishpondDao.findBysearch(params);
         return PageInfo.of(list);
    }

    public void add(Fishpond fishpond) {
        if(fishpond.getName()==null || " ".equals(fishpond.getName())){
            throw new CustomException("鱼塘名不能为空");
        }
        Fishpond fishpondName = fishpondDao.findByName(fishpond.getName());
        if(fishpondName != null){
            throw new CustomException("鱼塘已存在，请勿重复添加");
        }
         fishpondDao.insertSelective(fishpond);
    }

    public void update(Fishpond fishpond) {
        fishpondDao.updateByPrimaryKeySelective(fishpond);
    }

    public void detele(Integer id) {
        fishpondDao.deleteByPrimaryKey(id);
    }

    public int getFishpondTotal() {
        return fishpondDao.getFishpondTotal();
    }
}
