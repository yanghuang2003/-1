package com.ruoyi.wrms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.wrms.common.QueryPageParam;
import com.ruoyi.wrms.mapper.RecordMapper;
import com.ruoyi.wrms.pojo.Record;
import com.ruoyi.wrms.pojo.RecordRes;
import com.ruoyi.wrms.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<RecordRes> listAll() {
        return recordMapper.listAll();
    }

    @Override
    public List<RecordRes> listPage(QueryPageParam query) {
        return recordMapper.listPage(query);
    }
}
