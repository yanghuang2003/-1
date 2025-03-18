package com.ruoyi.wrms.controller;

import com.ruoyi.wrms.common.QueryPageParam;
import com.ruoyi.wrms.pojo.Goods;
import com.ruoyi.wrms.pojo.Record;
import com.ruoyi.wrms.pojo.RecordRes;
import com.ruoyi.wrms.service.GoodsService;
import com.ruoyi.wrms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/record")
public class RecordController {
    @Autowired
    private RecordService recordService;
    @Autowired
    private GoodsService goodsService;
    //查询
    @PostMapping("/listPage")
    public List<RecordRes> listPage(@RequestBody QueryPageParam params) {
        return recordService.listPage(params);
    }
    @GetMapping("/listAll")
    public List<RecordRes> list() {
        return recordService.listAll();
    }
    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Record record) {
        Goods goods = goodsService.getById(record.getGoods());
        int count = record.getCount();
        if (record.getAction().equals("2")){
            count = -count;
            record.setCount(count);
        }
        int newNum = goods.getCount() + count;
        if (newNum > 0){
            goods.setCount(newNum);
            goodsService.updateById(goods);
            return recordService.saveOrUpdate(record);
        }else return false;

    }

}
