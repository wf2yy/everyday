package com.smile.tkpro.pojo;


import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:07
 * @Description:
 */

@Data
@Table(name="student")
public class Student implements Serializable {

    private static final long serialVersionUID = -7450320312415814857L;

    /**
     * 学生id
     */
    @Id
    private  String sno;

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
    private  Date sbirthday;

    /**
     * 学生班级
     */
    private  String sclass;

    public Student() {
    }

    public Student(String sno, String sname, String ssex, Date sbirthday, String sclass) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirthday = sbirthday;
        this.sclass = sclass;
    }
}
