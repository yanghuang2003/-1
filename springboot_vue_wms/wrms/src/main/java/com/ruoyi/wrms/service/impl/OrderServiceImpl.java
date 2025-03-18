package com.ruoyi.wrms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.wrms.mapper.OrderManagementMapper;
import com.ruoyi.wrms.pojo.OrderManagement;
import com.ruoyi.wrms.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderManagementMapper, OrderManagement> implements OrderService {

}
