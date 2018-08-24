package com.smile.tkpro.service;

import com.smile.tkpro.mapper.StudentMapper;
import com.smile.tkpro.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:39
 * @Description:
 */
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id 查找Student
     * @param sno
     * @return
     */
    public Student findStudentById(String sno){
        return studentMapper.selectByPrimaryKey(sno);

    }

    public List<Student> findAll(){
        return studentMapper.selectAll();
    }
}
