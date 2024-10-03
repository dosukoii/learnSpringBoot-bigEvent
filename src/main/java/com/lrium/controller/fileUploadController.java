package com.lrium.controller;

import com.lrium.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class fileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException{
        //把文件内容存储再本地磁盘上
        String originalFilename =file.getOriginalFilename();
        //保证文件的名字是唯一的
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        file.transferTo(new File("D:\\store\\file\\"+filename));
        return Result.success("url访问地址...");
    }
}
