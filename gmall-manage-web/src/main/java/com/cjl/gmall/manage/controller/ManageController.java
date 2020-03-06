package com.cjl.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cjl.gmall.bean.*;
import com.cjl.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManageController {
    //通过dubbo调用manage-service中的服务
    @Reference
    private ManageService manageService;

    @RequestMapping("getCatalog1")
    public List<BaseCatalog1> getCatalog1(){
        return manageService.getCatalog1();
    }

    @RequestMapping("getCatalog2")
    public List<BaseCatalog2> getCatalog2(String catalog1Id){
        return manageService.getCatalog2(catalog1Id);
    }

    @RequestMapping("getCatalog3")
    public List<BaseCatalog3> getCatalog3(String catalog2Id){
        return manageService.getCatalog3(catalog2Id);
    }

    @RequestMapping("attrInfoList")
    public List<BaseAttrInfo> attrInfoList(String catalog3Id){
        return manageService.getAttrList(catalog3Id);
    }

    @RequestMapping("saveAttrInfo")
    public void saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo){
        // 调用服务层做保存方法
        manageService.saveAttrInfo(baseAttrInfo);
    }

    @RequestMapping(value = "getAttrValueList",method = RequestMethod.POST)
    public List<BaseAttrValue> getAttrValueList(String attrId){
        //先通过attrId查询平台属性
        BaseAttrInfo baseAttrInfo=manageService.getAttrInfo(attrId);
        //再返回平台属性中的平台属性值集合
        return baseAttrInfo.getAttrValueList();
    }

}
