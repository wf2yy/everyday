package com.smile.tkpro.controller;

import com.smile.tkpro.pojo.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * @author chengde
 * @create 2019/3/27 23:49
 * @desc
 */
@Api("mongodb学习")
@RestController
public class MongodbStudyController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @ApiOperation(value = "添加一个到mongodb",notes = "单条数据添加")
    @GetMapping("/addOne")
    private String save(){
        for (int i = 0; i < 5; i++){
            Article article = new Article();
            article.setTitle("Mongodb基本使用！");
            article.setAuthor("无双");
            article.setUrl("www.wushaung.xin" + i);
            article.setTags(Arrays.asList("java","mongodb","spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            mongoTemplate.save(article);
        }
        return "ok";
    }

    @ApiOperation(value = "添加一个集合到mongodb",notes = "集合数据添加")
    @GetMapping("/addList")
    private String saveList(){
        ArrayList<Article> objects = new ArrayList<Article>();
        for (int i = 0; i < 9; i++){
            Article article = new Article();
            article.setTitle("Mongodb基本使用！");
            article.setAuthor("无双"+ " " + i);
            article.setUrl("www.wushaung.xin" + i);
            article.setTags(Arrays.asList("java","mongodb","spring"));
            article.setVisitCount(0L);
            article.setAddTime(new Date());
            objects.add(article);
        }
        mongoTemplate.insert(objects,Article.class);
        return "ok";
    }
}
