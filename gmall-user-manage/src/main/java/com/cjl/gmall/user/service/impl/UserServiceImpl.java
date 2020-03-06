package com.cjl.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cjl.gmall.bean.UserAddress;
import com.cjl.gmall.bean.UserInfo;
import com.cjl.gmall.service.UserService;
import com.cjl.gmall.user.mapper.UserAddressMapper;
import com.cjl.gmall.user.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;
    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress userAddress=new UserAddress();
        userAddress.setUserId(userId);
        return userAddressMapper.select(userAddress);
    }
}
