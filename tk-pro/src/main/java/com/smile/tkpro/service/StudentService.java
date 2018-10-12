package com.smile.tkpro.service;

import com.smile.tkpro.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:39
 * @Description:
 */
@Service
public interface StudentService {



    /**
     * 根据id 查找Student
     * @param id
     * @return
     */
   Student findStudentById(Long id);

    /**
     * 查找所有学生
     * @return
     */
    public List<Student> findAll();

    /**
     * 添加学生
     * @param student
     * @return
     */
    public int addStudent(Student student);


    /**
     * 更新学生，传什么，更新什么
     * @param student
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 根据id删除学生
     * @param id
     * @return
     */
    public int deleteStudent(Long id);
}
