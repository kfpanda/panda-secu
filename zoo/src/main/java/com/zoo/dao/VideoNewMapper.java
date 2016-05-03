package com.zoo.dao;

import java.util.List;

import com.zoo.bean.VideoNew;

public interface VideoNewMapper {
    int deleteByPrimaryKey(Long id);
    int insert(VideoNew record);
    int insertSelective(VideoNew record);
    VideoNew selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(VideoNew record);
    int updateByPrimaryKey(VideoNew record);
    
    /**
     * 直播列表查询
     * @author xhb 
     */
    List<VideoNew> selectVideoList(VideoNew record);
}