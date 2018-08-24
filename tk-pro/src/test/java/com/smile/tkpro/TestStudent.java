package com.smile.tkpro;

import com.smile.tkpro.pojo.Student;
import com.smile.tkpro.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:43
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestStudent {

    @Autowired
    private StudentService studentService;

    @Test
    public void test(){
        System.out.println("hhhh");
    }

    @Test
    public void testFind(){
        Student s = studentService.findStudentById("107");
        System.out.println(s.getSname());
    }

    @Test
    public void testFindAll(){
        List<Student> all = studentService.findAll();

        System.out.println(all.get(1));
    }
}
