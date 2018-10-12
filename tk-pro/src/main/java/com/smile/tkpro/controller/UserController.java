package com.smile.tkpro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: chengde
 * @Date: 2018/8/23 10:17
 * @Description:
 */
@RestController
@Api("测试")
public class UserController {

    @ApiOperation("x")
    @GetMapping("/haha")
    public  String  test(){
        return"试试，我再试试";
    }
}
