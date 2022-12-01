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
import com.jeeplus.test.activiti.service.dto.TestActivitiLeaveDTO;
import com.jeeplus.test.activiti.service.TestActivitiLeaveService;

/**
 * 请假申请Controller
 * @author liugf
 * @version 2022-03-20
 */
@Api(tags ="请假申请")
@RestController
@RequestMapping(value = "/test/activiti/testActivitiLeave")
public class TestActivitiLeaveController {

	@Autowired
	private TestActivitiLeaveService testActivitiLeaveService;

	/**
	 * 请假申请列表数据
	 */
	@ApiLog("查询请假申请列表数据")
	@ApiOperation(value = "查询请假申请列表数据")
	@GetMapping("list")
	public ResponseEntity<IPage<TestActivitiLeaveDTO>> list(TestActivitiLeaveDTO testActivitiLeaveDTO, Page<TestActivitiLeaveDTO> page) throws Exception {
		QueryWrapper queryWrapper = QueryWrapperGenerator.buildQueryCondition (testActivitiLeaveDTO, TestActivitiLeaveDTO.class);
		IPage<TestActivitiLeaveDTO> result = testActivitiLeaveService.findPage (page, queryWrapper);
		return ResponseEntity.ok (result);
	}


	/**
	 * 根据Id获取请假申请数据
	 */
	@ApiLog("根据Id获取请假申请数据")
	@ApiOperation(value = "根据Id获取请假申请数据")
	@GetMapping("queryById")
	public ResponseEntity<TestActivitiLeaveDTO> queryById(String id) {
		return ResponseEntity.ok ( testActivitiLeaveService.findById ( id ) );
	}

	/**
	 * 保存请假申请
	 */
	@ApiLog("保存请假申请")
	@ApiOperation(value = "保存请假申请")
	@PostMapping("save")
	public  ResponseEntity <String> save(@Valid @RequestBody TestActivitiLeaveDTO testActivitiLeaveDTO) {
		//新增或编辑表单保存
		testActivitiLeaveService.saveOrUpdate (testActivitiLeaveDTO);
		return ResponseUtil.newInstance ( ).add("businessTable", "test_activiti_leave").add("businessId", testActivitiLeaveDTO.getId()).ok ("保存请假申请成功");
	}


	/**
	 * 删除请假申请
	 */
	@ApiLog("删除请假申请")
	@ApiOperation(value = "删除请假申请")
	@DeleteMapping("delete")
	public ResponseEntity <String> delete(String ids) {
		String idArray[] = ids.split(",");
		for(String id: idArray){
			testActivitiLeaveService.removeById ( id );
		}
		return ResponseEntity.ok( "删除请假申请成功" );
	}

}
