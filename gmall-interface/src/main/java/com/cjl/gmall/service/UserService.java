package com.cjl.gmall.service;

import com.cjl.gmall.bean.UserAddress;
import com.cjl.gmall.bean.UserInfo;

import java.util.List;

public interface UserService {
    /**
     * 查询所有数据
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据用户id查询用户地址列表
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
