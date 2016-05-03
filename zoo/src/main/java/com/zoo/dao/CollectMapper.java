package com.zoo.dao;

import com.zoo.bean.Collect;

public interface CollectMapper {
    int deleteByPrimaryKey(Long id);
    int insert(Collect record);
    int insertSelective(Collect record);
    Collect selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(Collect record);
    int updateByPrimaryKey(Collect record);
    Collect selectByCollect(Collect record);
}