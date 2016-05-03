package com.zoo.dao;

import com.zoo.bean.VideoHot;

public interface VideoHotMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VideoHot record);

    int insertSelective(VideoHot record);

    VideoHot selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VideoHot record);

    int updateByPrimaryKey(VideoHot record);
}