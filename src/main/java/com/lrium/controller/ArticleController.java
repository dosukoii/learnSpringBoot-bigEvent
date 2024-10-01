package com.lrium.controller;

import com.lrium.pojo.Article;
import com.lrium.pojo.PageBean;
import com.lrium.pojo.Result;
import com.lrium.service.ArticleService;
import com.lrium.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ){
        PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pb);
    }

//    @GetMapping("/list")
//    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/){
////        //验证token
////        try {
////            Map<String, Object> claims = JwtUtil.parseToken(token);
////            return Result.success("all data of article");
////        } catch (Exception e) {
////            //http响应状态码为401
////            response.setStatus(401);
////            return Result.error("未登录");
////        }
//        return Result.success("all data of article");
//    }
}
