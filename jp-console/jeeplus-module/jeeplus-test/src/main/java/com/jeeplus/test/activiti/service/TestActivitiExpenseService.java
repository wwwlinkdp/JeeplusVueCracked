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
import com.jeeplus.test.activiti.service.dto.TestActivitiExpenseDTO;
import com.jeeplus.test.activiti.service.mapstruct.TestActivitiExpenseWrapper;
import com.jeeplus.test.activiti.domain.TestActivitiExpense;
import com.jeeplus.test.activiti.mapper.TestActivitiExpenseMapper;

/**
 * 报销申请Service
 * @author liugf
 * @version 2022-03-20
 */
@Service
@Transactional
public class TestActivitiExpenseService extends ServiceImpl<TestActivitiExpenseMapper, TestActivitiExpense> {

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public TestActivitiExpenseDTO findById(String id) {
		TestActivitiExpenseDTO testActivitiExpenseDTO = baseMapper.findById ( id );
		return testActivitiExpenseDTO;
	}

	/**
	 * 自定义分页检索
	 * @param page
	 * @param queryWrapper
	 * @return
	 */
	public IPage <TestActivitiExpenseDTO> findPage(Page <TestActivitiExpenseDTO> page, QueryWrapper queryWrapper) {
		queryWrapper.eq ("a.del_flag", 0 ); // 排除已经删除
		return  baseMapper.findList (page, queryWrapper);
	}

	/**
	* 保存或者更新
	* @param  testActivitiExpenseDTO
	* @return
	*/
	public void saveOrUpdate(TestActivitiExpenseDTO testActivitiExpenseDTO) {
		TestActivitiExpense testActivitiExpense =  TestActivitiExpenseWrapper.INSTANCE.toEntity ( testActivitiExpenseDTO );
		super.saveOrUpdate (testActivitiExpense);
		testActivitiExpenseDTO.setId ( testActivitiExpense.getId () );
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
