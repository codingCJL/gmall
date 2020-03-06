package com.cjl.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cjl.gmall.bean.UserAddress;
import com.cjl.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    @Reference
    private UserService userService;


    @RequestMapping("getUserAddressList")
    @ResponseBody
    public List<UserAddress> getUserAddressList(String userId){
        return userService.getUserAddressList(userId);
    }
}
