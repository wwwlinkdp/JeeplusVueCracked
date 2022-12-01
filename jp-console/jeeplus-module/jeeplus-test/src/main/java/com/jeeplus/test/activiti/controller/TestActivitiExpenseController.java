/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.controller;

import javax.validation.Valid;
import com.jeeplus.common.utils.ResponseUtil;
import com.jeeplus.core.query.QueryWrapperGenerator;
import com.jeeplus.aop.logging.annotation.ApiLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.activiti.service.dto.TestActivitiExpenseDTO;
import com.jeeplus.test.activiti.service.TestActivitiExpenseService;

/**
 * 报销申请Controller
 * @author liugf
 * @version 2022-03-20
 */
@Api(tags ="报销申请")
@RestController
@RequestMapping(value = "/test/activiti/testActivitiExpense")
public class TestActivitiExpenseController {

	@Autowired
	private TestActivitiExpenseService testActivitiExpenseService;

	/**
	 * 报销申请列表数据
	 */
	@ApiLog("查询报销申请列表数据")
	@ApiOperation(value = "查询报销申请列表数据")
	@GetMapping("list")
	public ResponseEntity<IPage<TestActivitiExpenseDTO>> list(TestActivitiExpenseDTO testActivitiExpenseDTO, Page<TestActivitiExpenseDTO> page) throws Exception {
		QueryWrapper queryWrapper = QueryWrapperGenerator.buildQueryCondition (testActivitiExpenseDTO, TestActivitiExpenseDTO.class);
		IPage<TestActivitiExpenseDTO> result = testActivitiExpenseService.findPage (page, queryWrapper);
		return ResponseEntity.ok (result);
	}


	/**
	 * 根据Id获取报销申请数据
	 */
	@ApiLog("根据Id获取报销申请数据")
	@ApiOperation(value = "根据Id获取报销申请数据")
	@GetMapping("queryById")
	public ResponseEntity<TestActivitiExpenseDTO> queryById(String id) {
		return ResponseEntity.ok ( testActivitiExpenseService.findById ( id ) );
	}

	/**
	 * 保存报销申请
	 */
	@ApiLog("保存报销申请")
	@ApiOperation(value = "保存报销申请")
	@PostMapping("save")
	public  ResponseEntity <String> save(@Valid @RequestBody TestActivitiExpenseDTO testActivitiExpenseDTO) {
		//新增或编辑表单保存
		testActivitiExpenseService.saveOrUpdate (testActivitiExpenseDTO);
		return ResponseUtil.newInstance ( ).add("businessTable", "test_activiti_expense").add("businessId", testActivitiExpenseDTO.getId()).ok ("保存报销申请成功");
	}


	/**
	 * 删除报销申请
	 */
	@ApiLog("删除报销申请")
	@ApiOperation(value = "删除报销申请")
	@DeleteMapping("delete")
	public ResponseEntity <String> delete(String ids) {
		String idArray[] = ids.split(",");
		for(String id: idArray){
			testActivitiExpenseService.removeById ( id );
		}
		return ResponseEntity.ok( "删除报销申请成功" );
	}

}
