package com.smile.tkpro.controller;

import com.smile.tkpro.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chengde
 * @Date: 2018/8/24 10:50
 * @Description:
 */
@Api(description = "我就是描述一下")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation(value = "测试接口",notes = "只是测试")
    @GetMapping("/test")
    public String test(){
        return "接口测试";
    }


//    /**
//     * 查找所有的学生不分页
//     * @return
//     */
//    @ApiOperation(value = "查询所有学生",notes = "查询所有学生列表不分页")
//    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
//    public List<Student> findAll(){
//        return studentService.findAll();
//    }
//
//    /**
//     * 查找所有的学生不分页
//     * @return
//     */
//    @ApiOperation(value = "查找一个学生",notes = "查看一个学生")
//    @RequestMapping(value = "/findOne",method = RequestMethod.GET)
//    public Student findAll(@ApiParam(value = "学生ID", required = false) @RequestParam(required = false) Long id){
//        return studentService.findStudentById(id);
//    }


}
