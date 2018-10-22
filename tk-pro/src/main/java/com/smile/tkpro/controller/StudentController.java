package com.smile.tkpro.controller;

import com.smile.tkpro.common.ResponseWrapper;
import com.smile.tkpro.pojo.Student;
import com.smile.tkpro.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Auther: chengde
 * @Date: 2018/8/24 10:50
 * @Description:
 */
@Api(description = "学生接口增删改查")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 查找所有的学生不分页
     * @return
     */
    @ApiOperation(value = "查询所有学生",notes = "查询所有学生列表不分页")
    @GetMapping("/allStudents")
    public ResponseWrapper findAll(){
        List<Student> studens = studentService.findAll();
        return ResponseWrapper.success("查询学生列表成功",studens);
    }

    /**
     * 查找一个学生
     * @return
     */
    @ApiOperation(value = "查找一个学生",notes = "查看一个学生")
    @ApiResponses({ @ApiResponse(code = 200, message = "操作成功"),
            @ApiResponse(code = 500, message = "服务器内部异常"),
            @ApiResponse(code = 403, message = "权限不足") })
    @GetMapping("/student")
    public ResponseWrapper findAll(@ApiParam(value = "学生ID", required = true) @RequestParam(required = true) Long id){
        Student student = studentService.findStudentById(id);
        return ResponseWrapper.success(student);
    }


    @ApiOperation(value = "添加一个学生",notes = "新增学生，注意必要的参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sname", value = "学生姓名", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "ssex", value = "学生性别", required = true, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "sbirthday", value = "学生生日，格式(yyyy-MM-dd HH:mm:ss）", required = false, paramType = "form", dataType = "Date"),
            @ApiImplicitParam(name = "sclass", value = "学生班级", required = true, paramType = "form", dataType = "String",defaultValue = "终极一班")
    })
    @PostMapping("/student")
    public ResponseWrapper add(@ApiIgnore Student student){
        int i = studentService.addStudent(student);
        return ResponseWrapper.success("新增学生成功");
    }

    @ApiOperation(value = "更新一个学生",notes = "更新学生",httpMethod = "PUT")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "学生id", required = true, paramType = "form", dataType = "Long"),
            @ApiImplicitParam(name = "sname", value = "学生姓名", required = false, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "ssex", value = "学生性别", required = false, paramType = "form", dataType = "String"),
            @ApiImplicitParam(name = "sbirthday", value = "学生生日", required = false, paramType = "form", dataType = "Date"),
            @ApiImplicitParam(name = "sclass", value = "学生班级", required = false, paramType = "form", dataType = "String")
    })
    @PutMapping("/student")
    public ResponseWrapper update(@ApiIgnore Student student) {
        int i = studentService.updateStudent(student);
        if (i > 0) {
            return ResponseWrapper.success("更新成功！");
        }
        return ResponseWrapper.error("更新失败！");
    }


    @ApiOperation(value = "删除一个学生",notes = "删除一个学生")
    @DeleteMapping("/student")
    public ResponseWrapper delete(@ApiParam(value = "学生ID", required = true) @RequestParam(required = true) Long id){
        int i = studentService.deleteStudent(id);
        if (i > 0) {
            return ResponseWrapper.success("删除成功！");
        }
        return ResponseWrapper.error("删除失败！");
    }





}
