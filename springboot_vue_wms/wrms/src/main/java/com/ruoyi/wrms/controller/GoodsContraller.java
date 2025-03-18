package com.ruoyi.wrms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ruoyi.wrms.pojo.Goods;
import com.ruoyi.wrms.service.GoodsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Tag(name = "商品接口管理", description = "商品相关的接口")
public class GoodsContraller {

    @Autowired
    private GoodsService goodsService;
    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Goods goods){
        return goodsService.save(goods);
    }
    //更新
    @PostMapping("/update")
    public boolean update(@RequestBody Goods goods){
        return goodsService.updateById(goods);
    }
    //删除
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return goodsService.removeById(id);
    }
    //查询
    @PostMapping("/listPage")
    public List<Goods> listP(@RequestBody Goods goods) {
        LambdaQueryWrapper<Goods> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String goodsType = goods.getGoodsType();
        if (StringUtils.isNotBlank(goodsType)) {
            lambdaQueryWrapper.eq(Goods::getGoodsType, goodsType.trim());
        }
        int storage = goods.getStorage();
        if (storage != 0) {
            lambdaQueryWrapper.eq(Goods::getStorage, storage);
        }
        String name = goods.getName();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(Goods::getName, name.trim());
        }
        String imageName = goods.getImageName();
        if (StringUtils.isNotBlank(imageName)) {

        }
        return goodsService.list(lambdaQueryWrapper);
    }
}
