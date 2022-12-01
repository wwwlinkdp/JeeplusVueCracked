/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.service;

import com.jeeplus.sys.constant.CommonConstants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.activiti.service.dto.TestActivitiLeaveDTO;
import com.jeeplus.test.activiti.service.mapstruct.TestActivitiLeaveWrapper;
import com.jeeplus.test.activiti.domain.TestActivitiLeave;
import com.jeeplus.test.activiti.mapper.TestActivitiLeaveMapper;

/**
 * 请假申请Service
 * @author liugf
 * @version 2022-03-20
 */
@Service
@Transactional
public class TestActivitiLeaveService extends ServiceImpl<TestActivitiLeaveMapper, TestActivitiLeave> {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public TestActivitiLeaveDTO findById(String id) {
		TestActivitiLeaveDTO testActivitiLeaveDTO = baseMapper.findById ( id );
		return testActivitiLeaveDTO;
	}

	/**
	 * 自定义分页检索
	 * @param page
	 * @param queryWrapper
	 * @return
	 */
	public IPage <TestActivitiLeaveDTO> findPage(Page <TestActivitiLeaveDTO> page, QueryWrapper queryWrapper) {
		queryWrapper.eq ("a.del_flag", 0 ); // 排除已经删除
		return  baseMapper.findList (page, queryWrapper);
	}

	/**
	* 保存或者更新
	* @param  testActivitiLeaveDTO
	* @return
	*/
	public void saveOrUpdate(TestActivitiLeaveDTO testActivitiLeaveDTO) {
		TestActivitiLeave testActivitiLeave =  TestActivitiLeaveWrapper.INSTANCE.toEntity ( testActivitiLeaveDTO );
		super.saveOrUpdate (testActivitiLeave);
		testActivitiLeaveDTO.setId ( testActivitiLeave.getId () );
	}

	/**
	 * 删除
	 * @param  id
	 * @return
	 */
	public void removeById(String id) {
		super.removeById ( id );
	}

}
