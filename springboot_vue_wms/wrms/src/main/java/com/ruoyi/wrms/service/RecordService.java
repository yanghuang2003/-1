package com.ruoyi.wrms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.wrms.common.QueryPageParam;
import com.ruoyi.wrms.pojo.Record;
import com.ruoyi.wrms.pojo.RecordRes;

import java.util.List;
import java.util.Queue;


public interface RecordService extends IService<Record> {
    List<RecordRes> listAll();
    List<RecordRes> listPage(QueryPageParam query);
}
