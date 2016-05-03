package com.zoo.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.awifi.util.StringUtils;
import com.zoo.bean.VideoNew;
import com.zoo.dao.VideoNewMapper;

@Service
public class VideoService {

	/** * 引入 VideoNewMapper */
	@Resource
	private VideoNewMapper videoNewMapper;
	/** 日志 */
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public Map<String, String> vidioList(String zbname, String vname,
			String type) {
		VideoNew videoNew = new VideoNew();
		Map<String, String> ret = new HashMap<String, String>();
		if (StringUtils.isNotEmpty(zbname)) {
			videoNew.setZbname("%" + zbname + "%");
		}
		if (StringUtils.isNotEmpty(vname)) {
			videoNew.setVname("%" + vname + "%");
		}
		if (StringUtils.isNotEmpty(type)) {
			videoNew.setType(type);
		}
		try {
			ret.put("type", "OK");
			ret.put("ret", JSON.toJSONString(videoNewMapper.selectVideoList(videoNew)));
			return ret;
		} catch (Exception e) {
			logger.error("VideoService.vidioList.catch", e);
			ret.put("type", "Fall");
			ret.put("ret", e.getMessage());
		}
		return ret;
	}
}
