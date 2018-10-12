package com.smile.tkpro.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.smile.tkpro.base.BaseDomain;
import lombok.Data;

import javax.persistence.Table;
import java.util.Date;
/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:07
 * @Description:
 */

@Data
@Table(name="student")
public class Student extends BaseDomain {


    /**
     * 学生姓名
     */
    private  String sname;

    /**
     * 学生性别
     */
    private  String ssex;

    /**
     * 学生生日
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private  Date sbirthday;

    /**
     * 学生班级
     */
    private  String sclass;

    public Student() {
    }

    public Student(String sname, String ssex, Date sbirthday, String sclass) {
        this.sname = sname;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.sclass = sclass;
    }
}
