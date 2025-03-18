package com.ruoyi.wrms.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.ruoyi.wrms.pojo.Storage;
import com.ruoyi.wrms.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageContraller {

    @Autowired
    private StorageService storageService;
//    @Qualifier("redisTemplate")
//    @Autowired
//    private RedisTemplate redisTemplate;

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody Storage storage){
        return storageService.save(storage);
    }
    //更新
    @PostMapping("/update")
    public boolean update(@RequestBody Storage storage){
        return storageService.updateById(storage);
    }
    //删除
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam Integer id){
        return storageService.removeById(id);
    }
    //查询
    @PostMapping("/listPage")
    public List<Storage> listP(@RequestBody Storage storage) {

//        //构造redis中的key，规则:"storage_"+id
//        String key = "storage_"+storage.getId();
//        //查询redis中是否有数据
//        List<Storage> list =(List<Storage>) redisTemplate.opsForValue().get(key);
//        if (list != null && !list.isEmpty()) {
//            //如果存在，直接返回，无需查询数据库
//            return list;
//        }
//        //如果不存在，查询数据库，并将数据保存到redis中
//
        LambdaQueryWrapper<Storage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = storage.getName();
        if (StringUtils.isNotBlank(name)) {
            lambdaQueryWrapper.like(Storage::getName, name.trim());
        }
//        redisTemplate.opsForValue().set(key, storageService.list(lambdaQueryWrapper));
        return storageService.list(lambdaQueryWrapper);
    }
    //展示所有数据
    @GetMapping("/list")
    public List<Storage> list(){
        return storageService.list();
    }
}
