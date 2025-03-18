package com.ruoyi.wrms.controller;

import com.ruoyi.wrms.common.Result;
import com.ruoyi.wrms.pojo.Menu;
import com.ruoyi.wrms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;
    @GetMapping("/list")
    public Result list(@RequestParam String roleId){
        List<Menu> list = menuService.lambdaQuery().like(Menu::getMenuRight, roleId).list();
        return Result.success(list);
    }
}
