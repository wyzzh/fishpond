package com.example.service;

import com.example.dao.CultivationDao;
import com.example.entity.Animal;
import com.example.entity.Cultivation;
import com.example.entity.Params;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CultivationService {
    @Resource
    private CultivationDao cultivationDao;

    public List<Cultivation> getCultivation() {
        return cultivationDao.selectAll();
    }

    public PageInfo<Cultivation> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),5);
        List<Cultivation> list = cultivationDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public void add(Cultivation cultivation) {
        cultivationDao.insertSelective(cultivation);
    }

    public void update(Cultivation cultivation) {
        cultivationDao.updateByPrimaryKeySelective(cultivation);
    }

    public void detele(Integer id) {
        cultivationDao.deleteByPrimaryKey(id);
    }


    public int getcultivationTotal() {
        return cultivationDao.getCultivationTotal();
    }
}
