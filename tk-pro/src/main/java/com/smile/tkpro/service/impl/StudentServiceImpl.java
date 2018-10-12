package com.smile.tkpro.service.impl;

import com.smile.tkpro.mapper.StudentMapper;
import com.smile.tkpro.pojo.Student;
import com.smile.tkpro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:39
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据id 查找Student
     * @param id
     * @return
     */
    @Override
    public Student findStudentById(Long id){
        return studentMapper.selectByPrimaryKey(id);

    }

    /**
     * 查找所有学生
     * @return
     */
    @Override
    public List<Student> findAll(){
        return studentMapper.selectAll();
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    @Override
    public int addStudent(Student student){
        return studentMapper.insertSelective(student);
    }


    /**
     * 更新学生，传什么，更新什么
     * @param student
     * @return
     */
    @Override
    public int updateStudent(Student student){
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    @Override
    public int deleteStudent(Long id){
        return studentMapper.deleteByPrimaryKey(id);
    }
}
