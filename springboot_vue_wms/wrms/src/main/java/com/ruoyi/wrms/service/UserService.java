package com.ruoyi.wrms.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.wrms.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> listAll();
    IPage<User> page(Page<User> page, LambdaQueryWrapper<User> lambdaQueryWrapper);
    User login(User user);
}
