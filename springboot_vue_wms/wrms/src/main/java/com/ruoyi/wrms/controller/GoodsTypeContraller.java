package com.ruoyi.wrms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ruoyi.wrms.pojo.GoodsType;
import com.ruoyi.wrms.pojo.Storage;
import com.ruoyi.wrms.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goodstype")
public class GoodsTypeContraller {

    @Autowired
    private GoodsTypeService goodsTypeService;
    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody GoodsType goodsType){
        return goodsTypeService.save(goodsType);
    }
    //更新
    @PostMapping("/update")
    public boolean update(@RequestBody GoodsType goodsType){
        return goodsTypeService.updateById(goodsType);
    }
    //删除
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return goodsTypeService.removeById(id);
    }
    //查询
    @PostMapping("/listPage")
    public List<GoodsType> listP(@RequestBody GoodsType goodsType) {
        LambdaQueryWrapper<GoodsType> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = goodsType.getName();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(GoodsType::getName, name.trim());
        }
        return goodsTypeService.list(lambdaQueryWrapper);
    }
    //展示所有数据
    @GetMapping("/list")
    public List<GoodsType> list(){
        return goodsTypeService.list();
    }
}
