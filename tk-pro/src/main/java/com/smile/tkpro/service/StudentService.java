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

    /**
     * 查找所有学生
     * @return
     */
    public List<Student> findAll(){
        return studentMapper.selectAll();
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int addStudent(Student student){
        return studentMapper.insertSelective(student);
    }


    /**
     * 更新学生，传什么，更新什么
     * @param student
     * @return
     */
    public int updateStudent(Student student){
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    public int deleteStudent(Long id){
        return studentMapper.deleteByPrimaryKey(id);
    }
}
