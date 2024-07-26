package com.example.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.JwtInterceptor;
import com.example.common.Result;
import com.example.entity.Params;
import com.example.entity.Person;
import com.example.exception.CustomException;
import com.example.service.PersonService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    private PersonService personService;

    private static final Logger log = LoggerFactory.getLogger(PersonController.class);

    @PostMapping("/login")
    public Result login(@RequestBody Person person){
         Person user =personService.login(person);
        return Result.success(user);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Person person){
        personService.add(person);
        return Result.success();
    }


    @GetMapping("/personTotal")
    public Result getPersonTotal() {
        int total = personService.getPersonTotal();
        return Result.success(total);
    }

    @GetMapping("")
    public Result getPerson() {
        List<Person> list = personService.getPerson();
        return Result.success(list);
    }

    @GetMapping("/search")
    public Result findBySearch(Params params) {
        log.info("拦截器已放行，调用信息");
        PageInfo<Person> info = personService.findBysearch(params);
        return Result.success(info);
    }

    @PostMapping("")
    public Result save(@RequestBody Person person) {
        if (person.getId() == null) {
            personService.add(person);
        } else {
            personService.update(person);
        }
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        personService.detele(id);
        return Result.success();
    }

    @GetMapping("/export")
    public Result export(HttpServletResponse response) throws IOException {
        //1.从数据库中查询全部数据
        List<Person> all = personService.findAll();
        if (CollectionUtil.isEmpty(all)) {
            throw new CustomException("未找到数据");
        }
        //2.定义一个list和Map<Key,Value>出来，储存处理之后的数据，塞到list里
        List<Map<String, Object>> list = new ArrayList<>(all.size());
        //3.遍历每一条数据，然后封装到Map<Key,Value>里，把这个map塞到list里
        for (Person person : all) {
            Map<String, Object> row = new HashMap<>();
            row.put("名字", person.getName());
            row.put("性别", person.getSex());
            row.put("身份证号", person.getIdNumber());
            row.put("学历", person.getEducation());
            row.put("岗位", person.getPosition());
            row.put("技能", person.getSkills());
            row.put("入职时间", person.getHireDate());
            list.add(row);
        }
        //4.创建ExcelWriter，把list用writer写出来。
        ExcelWriter wr = ExcelUtil.getWriter(true);
        wr.write(list, true);
        //5.把excel下载下来。
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        response.setHeader("Content-Dispositon", "attachment;filename=person.xlsx");
        ServletOutputStream out = response.getOutputStream();
        wr.flush(out, true);
        wr.close();
        IoUtil.close(System.out);
        return Result.success();
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws IOException{
        List<Person> infoList =ExcelUtil.getReader(file.getInputStream()).readAll(Person.class);
        System.out.println(infoList);
        if (!CollectionUtil.isEmpty(infoList));
        boolean hasFailure = false;
        for (Person person:infoList) {
            try{
                personService.add(person);
            }catch (Exception e){
                e.printStackTrace();
                hasFailure = true;
            }
        }
        if (hasFailure) {
            return Result.error("导入失败");
        }
        return Result.success();
    }
}
