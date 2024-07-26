package com.example.service;

import com.example.dao.PondCultivationDao;
import com.example.entity.Cultivation;
import com.example.entity.Params;
import com.example.entity.PondCultivation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PondCultivationService {
    @Resource
    private PondCultivationDao pondCultivationDao;


    public PageInfo<PondCultivation> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),5);
        List<PondCultivation> list = pondCultivationDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public void add(PondCultivation pondCultivation) {
        pondCultivationDao.insertSelective(pondCultivation);
    }

    public void update(PondCultivation pondCultivation) {
        pondCultivationDao.updateByPrimaryKeySelective(pondCultivation);
    }

    public void detele(Integer id) {
        pondCultivationDao.deleteByPrimaryKey(id);
    }
}
