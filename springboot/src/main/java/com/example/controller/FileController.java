package com.example.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/files")
public class FileController {
    //文件上传存储路径
    private static final String filePath = System.getProperty("user.dir") + "/file/";

    //文件上传
    @PostMapping("/upload")
    public Result upload(MultipartFile file) {
        synchronized (FileController.class) {
            //获取当前时间戳
            String flag = System.currentTimeMillis() + "";
            //文件原始名字
            String fileName = file.getOriginalFilename();
            try {
                //如果没有file文件夹，会给你在项目跟目录下创建file文件夹
                if (!FileUtil.isDirectory(filePath)) {
                    FileUtil.mkdir(filePath);
                }
                //文件存储形式，：时间戳-文件名
                FileUtil.writeBytes(file.getBytes(), filePath + flag + "-" + fileName);
                System.out.println(fileName + "上传成功");
                Thread.sleep(1L);
            } catch (Exception e) {
                System.err.println(fileName + "上传失败");
            }
            return Result.success(flag);
        }
    }

    //获取文件
    @GetMapping("/{flag}")
    public void avatarPat(@PathVariable String flag, HttpServletResponse response) {
        if (!FileUtil.isDirectory(filePath)) {
            FileUtil.mkdir(filePath);
        }
        List<String> fileNames = FileUtil.listFileNames(filePath);
        String avatar = fileNames.stream().filter(name -> name.contains(flag)).findAny().orElse("");

        if (StrUtil.isNotEmpty(avatar)) {
            try (OutputStream os = response.getOutputStream()) {
                response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(avatar, "UTF-8"));
                response.setContentType("application/octet-stream");
                byte[] bytes = FileUtil.readBytes(filePath + avatar);
                os.write(bytes);
                os.flush();
            } catch (Exception e) {
                System.err.println("文件下载失败");
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
