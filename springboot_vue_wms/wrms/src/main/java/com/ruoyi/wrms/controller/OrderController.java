package com.ruoyi.wrms.controller;

import com.ruoyi.wrms.common.Result;
import com.ruoyi.wrms.pojo.OrderManagement;
import com.ruoyi.wrms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody OrderManagement orderManagement){
        return orderService.save(orderManagement);
    }
    //更新
    @PostMapping("/update")
    public boolean update(@RequestBody OrderManagement orderManagement){
        return orderService.updateById(orderManagement);
    }
    //删除
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return orderService.removeById(id);
    }
    @PostMapping("/listPage")
    public Result list(@RequestBody OrderManagement orderManagement){
        String orderNumber = orderManagement.getOrderNumber();
        LambdaQueryWrapper<OrderManagement> wrapper = new LambdaQueryWrapper<>();
        if (!"".equals(orderNumber)){
            wrapper.eq(OrderManagement::getOrderNumber,orderNumber);
        }
        return Result.success(orderService.list(wrapper));

    }
}
