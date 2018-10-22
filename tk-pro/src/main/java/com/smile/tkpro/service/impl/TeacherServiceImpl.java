package com.smile.tkpro.service.impl;

import com.smile.tkpro.mapper.TeacherMapper;
import com.smile.tkpro.pojo.Teacher;
import com.smile.tkpro.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:39
 * @Description:
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;


    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.insertSelective(teacher);
    }
}
