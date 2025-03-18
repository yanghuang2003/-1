package com.ruoyi.wrms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.wrms.mapper.UserMapper;
import com.ruoyi.wrms.pojo.User;
import com.ruoyi.wrms.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> listAll() {
        return userMapper.listAll();
    }

    @Override
    public IPage<User> page(Page<User> page, LambdaQueryWrapper<User> lambdaQueryWrapper) {
        return baseMapper.selectPage(page, lambdaQueryWrapper);
    }
    //TODO：登录改造，密文
    @Override
    public User login(User user) {
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User userByNo = userMapper.findByNo(user.getNo());
        if (userByNo != null && userByNo.getPassword().equals(password)){
            return userByNo;
        }else {
            return null;
        }

    }
}

