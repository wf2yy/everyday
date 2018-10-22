package com.smile.tkpro.controller;

import com.smile.tkpro.common.ResponseWrapper;
import com.smile.tkpro.pojo.Teacher;
import com.smile.tkpro.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chengde
 * @Date: 2018/8/24 10:50
 * @Description:
 */
@Api(description = "教师接口")
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation(value = "新增一个老师",notes = "新增老师，注意必要的参数")
    @PostMapping("/teacher")
    public ResponseWrapper add(@RequestBody Teacher teacher){
        int i = teacherService.addTeacher(teacher);
        return ResponseWrapper.success("新增老师成功");
    }






}
