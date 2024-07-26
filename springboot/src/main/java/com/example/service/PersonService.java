package com.example.service;

import com.example.common.JwtTokenUtils;
import com.example.dao.PersonDao;
import com.example.entity.Fishpond;
import com.example.entity.Params;
import com.example.entity.Person;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonService {
    @Resource
    private PersonDao personDao;

    public Person login(@RequestBody Person person) {
        if(person.getName()==null){
            throw new CustomException("用户名不能为空");
        }
        if(person.getPassword()==null){
            throw new CustomException("密码不能为空");
        }
        Person user = personDao.findByNameAndPassword(person.getName(),person.getPassword());
        if(user == null){
            throw new CustomException("用户名或者密码输入错误");
        }
        // 生成jwt token给前端
        String token = JwtTokenUtils.genToken(user.getId().toString(), user.getPassword());
        user.setToken(token);

        return user;
    }

    public PageInfo<Person> findBysearch(Params params) {
        PageHelper.startPage(params.getCurrentPage(),3);
        List<Person> list = personDao.findBysearch(params);
        return PageInfo.of(list);
    }

    public List<Person> getPerson() {
        return personDao.getPerson();
    }

    public void  add(Person person) {
        if(person.getName()==null || " ".equals(person.getName())){
            throw new CustomException("用户名不能为空");
        }
        Person user = personDao.findByName(person.getName());
        if(user != null){
            throw new CustomException("用户名已存在，请更换用户名");
        }
        if(person.getPassword()==null){
            person.setPassword("123456");
        }
        personDao.insertSelective(person);
    }

    public boolean  update(Person person) {
        int result = personDao.updateByPrimaryKeySelective(person);
        return result > 0;
    }

    public void detele(Integer id) {
        personDao.deleteByPrimaryKey(id);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public Integer getPersonTotal() {
        return personDao.getPersonTotal();
    }


    public Person findById(Integer id) {
        return personDao.selectByPrimaryKey(id);
    }
}
