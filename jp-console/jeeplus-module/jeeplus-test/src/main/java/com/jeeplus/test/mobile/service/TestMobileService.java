/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.mobile.service.dto.TestMobileDTO;
import com.jeeplus.test.mobile.domain.TestMobile;
import com.jeeplus.test.mobile.mapper.TestMobileMapper;

/**
 * 测试移动表单Service
 * @author 刘高峰
 * @version 2022-04-13
 */
@Service
@Transactional
public class TestMobileService extends ServiceImpl<TestMobileMapper, TestMobile> {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public TestMobileDTO findById(String id) {
		return baseMapper.findById ( id );
	}

	/**
	 * 自定义分页检索
	 * @param page
	 * @param queryWrapper
	 * @return
	 */
	public IPage <TestMobileDTO> findPage(Page <TestMobileDTO> page, QueryWrapper queryWrapper) {
		queryWrapper.eq ("a.del_flag", 0 ); // 排除已经删除
		return  baseMapper.findList (page, queryWrapper);
	}

}
