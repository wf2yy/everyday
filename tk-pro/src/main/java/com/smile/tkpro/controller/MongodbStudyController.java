package com.smile.tkpro.controller;

import com.smile.tkpro.pojo.Article;
import com.smile.tkpro.pojo.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @ApiOperation(value = "添加一个Person到mongodb",notes = "单条数据添加")
    @PostMapping("/addOnePerson")
    private String savePerson(){

            Person person = new Person();
            person.setName("晴天");
            person.setCity("北京");
            person.setAge(18);
            person.setRegion("昌平区育知路");
            mongoTemplate.save(person);
             return "ok";
    }

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

    /**
     *
     * @param update 1 只更新符合条件的一条数据，2全部更新
     * @return
     */
    @ApiOperation(value = "添加一个集合到mongodb",notes = "集合数据添加")
    @GetMapping("/update")
    private String updateWanted(@RequestParam Integer update){

        //更新符合条件的第一条记录
        Integer updateOne = 1;

        //更新符合条件的所有记录
        Integer updateAll = 2;

        //更新符合条件的一条记录，如果没有这个记录就新添加一条数据
        Integer upsert = 3;

        //更新符合条件的条记录，特殊更新，若果不存在这个更新的则断就自己添加一个字段
        Integer updateAddField = 4;

        //更新符合条件的条记录，在当前数字基础上加
        Integer updateInc = 5;

        //更新符合条件的条记录，修改key的名称
        Integer updateFieldName = 6;

        //更新符合条件的条记录，删除字段key
        Integer updateDeleteField = 7;

        //更新符合条件的条记录，删除数组中的值
        Integer updateDeleteArray = 8;

        Query query = Query.query(Criteria.where("author").is("无双 10"));
        Update update1 = Update.update("title", "MongodbTemplete使用啊啊").set("visitCount", 10);

        if (updateOne.equals(update)){
            //更新符合条件的第一条记录
            mongoTemplate.updateFirst(query,update1,Article.class);
        }else if (updateAll.equals(update)){
            //更新全部符合条件的记录
            mongoTemplate.updateMulti(query,update1,Article.class);
        }else if (upsert.equals(update)){
            //更新符合条件的一条记录，如果没有这个记录就新添加一条数据
            mongoTemplate.upsert(query,update1,Article.class);
        }else if (updateAddField.equals(update)){
            //更新符合条件的条记录，特殊更新，若果不存在这个更新的字段就自己添加一个字段
            Update updateAdd = Update.update("title", "MongodbTemplete使用啊啊").set("star", new String[]{"beidou","xiqoqi"});
            mongoTemplate.updateMulti(query,updateAdd,Article.class);
        }else if (updateInc.equals(update)){
            Update updateMoney = Update.update("title", "MongodbTemplete使用啊啊").inc("total",100);
            //更新符合条件的条记录，在当前数字基础上加
            mongoTemplate.updateMulti(query,updateMoney,Article.class);
        }else if (updateFieldName.equals(update)){
            //更新符合条件的条记录，修改key的名称
            Update updateRename = Update.update("title", "MongodbTemplete").rename("vc","my_word");
            mongoTemplate.updateMulti(query,updateRename,Article.class);
        }else if (updateDeleteField.equals(update)){
            //更新符合条件的条记录，删除字段key
            Update updateDeleteKey = Update.update("title", "MongodbTemplete使用啊啊").unset("my_word");
            mongoTemplate.updateMulti(query,updateDeleteKey,Article.class);
        }else if (updateDeleteArray.equals(update)){
            //更新符合条件的条记录，删除数组中的某个值
            Update updatePullFromArray = Update.update("title", "MongodbTemplete使用啊啊").pull("tags","java");
            mongoTemplate.updateMulti(query,updatePullFromArray,Article.class);
        }
        return "ok";
    }
}
