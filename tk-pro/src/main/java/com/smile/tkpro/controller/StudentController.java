package com.smile.tkpro.controller;

import com.smile.tkpro.pojo.Student;
import com.smile.tkpro.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/24 10:50
 * @Description:
 */
@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/test")
    public String test(){
        return "接口测试";
    }


    /**
     * 查找所有的学生不分页
     * @return
     */
    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentService.findAll();
    }
}
