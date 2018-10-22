package com.smile.tkpro.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:07
 * @Description:
 */

@ApiModel(value="教师对象",description="教师对象")
@Data
@Table(name="teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
   private Long id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="修改时间",name="gmtCreate",example="2018-11-11 12:12:12")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间",name="gmtModified",example="2018-11-11 12:12:12")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;


    /**
     * 学生姓名
     */
    @ApiModelProperty(value="教师姓名",name="tname",example="王老师")
    private  String tname;

    /**
     * 学生性别
     */
    @ApiModelProperty(value="教师性别",name="tsex",example="1")
    private  String tsex;

    /**
     * 学生生日
     */
    @ApiModelProperty(value="教师生日",name="tbirthday",example="2018-11-11 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date tbirthday;

    /**
     * 学生班级
     */
    @ApiModelProperty(value="教授班级",name="tclass",example="一班")
    private  String tclass;


}
