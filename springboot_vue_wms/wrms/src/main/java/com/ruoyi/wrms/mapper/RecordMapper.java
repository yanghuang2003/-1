package com.ruoyi.wrms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.ruoyi.wrms.common.QueryPageParam;
import com.ruoyi.wrms.pojo.Record;
import com.ruoyi.wrms.pojo.RecordRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface RecordMapper extends BaseMapper<Record> {
    List<RecordRes> listAll();
    List<RecordRes> listPage(QueryPageParam query);

}
