package com.smile.tkpro.service;

import com.smile.tkpro.pojo.Teacher;
import org.springframework.stereotype.Service;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:39
 * @Description:
 */
@Service
public interface TeacherService {



    /**
     * 添加老师
     * @param teacher
     * @return
     */
    public int addTeacher(Teacher teacher);



}
