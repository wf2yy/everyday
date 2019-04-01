package com.smile.tkpro.pojo;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * @author chengde
 * @create 2019/3/29 10:56
 * @desc mongodb 索引
 * 组合索引要在类上加@CompoundIndexes，def表示组合索引的字段和索引存储升序 1 ，降序 -1
 * 单个索引@Indexed,里面可以填写对应参数
 */
@Data
@Document
@CompoundIndexes(
        @CompoundIndex(name = "city_region_idx",def = "{'city':1,'region':1}")
)
public class Person {

    @Id
    private String id;

    /**
     * 差创建唯一索引
     */
    @Indexed(unique = true)
    private String name;

    /**
     * 后台创建索引
     */
    @Indexed(background = true)
    private int age;

    private String city;

    private String region;
}
