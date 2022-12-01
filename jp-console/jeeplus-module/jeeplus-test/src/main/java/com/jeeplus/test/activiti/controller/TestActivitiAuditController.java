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
import com.jeeplus.test.activiti.service.dto.TestActivitiAuditDTO;
import com.jeeplus.test.activiti.service.TestActivitiAuditService;

/**
 * 薪酬调整申请Controller
 * @author liugf
 * @version 2022-03-20
 */
@Api(tags ="薪酬调整申请")
@RestController
@RequestMapping(value = "/test/activiti/testActivitiAudit")
public class TestActivitiAuditController {

	@Autowired
	private TestActivitiAuditService testActivitiAuditService;

	/**
	 * 薪酬调整申请列表数据
	 */
	@ApiLog("查询薪酬调整申请列表数据")
	@ApiOperation(value = "查询薪酬调整申请列表数据")
	@GetMapping("list")
	public ResponseEntity<IPage<TestActivitiAuditDTO>> list(TestActivitiAuditDTO testActivitiAuditDTO, Page<TestActivitiAuditDTO> page) throws Exception {
		QueryWrapper queryWrapper = QueryWrapperGenerator.buildQueryCondition (testActivitiAuditDTO, TestActivitiAuditDTO.class);
		IPage<TestActivitiAuditDTO> result = testActivitiAuditService.findPage (page, queryWrapper);
		return ResponseEntity.ok (result);
	}


	/**
	 * 根据Id获取薪酬调整申请数据
	 */
	@ApiLog("根据Id获取薪酬调整申请数据")
	@ApiOperation(value = "根据Id获取薪酬调整申请数据")
	@GetMapping("queryById")
	public ResponseEntity<TestActivitiAuditDTO> queryById(String id) {
		return ResponseEntity.ok ( testActivitiAuditService.findById ( id ) );
	}

	/**
	 * 保存薪酬调整申请
	 */
	@ApiLog("保存薪酬调整申请")
	@ApiOperation(value = "保存薪酬调整申请")
	@PostMapping("save")
	public  ResponseEntity <String> save(@Valid @RequestBody TestActivitiAuditDTO testActivitiAuditDTO) {
		//新增或编辑表单保存
		testActivitiAuditService.saveOrUpdate (testActivitiAuditDTO);
		return ResponseUtil.newInstance ( ).add("businessTable", "test_activiti_audit").add("businessId", testActivitiAuditDTO.getId()).ok ("保存薪酬调整申请成功");
	}


	/**
	 * 删除薪酬调整申请
	 */
	@ApiLog("删除薪酬调整申请")
	@ApiOperation(value = "删除薪酬调整申请")
	@DeleteMapping("delete")
	public ResponseEntity <String> delete(String ids) {
		String idArray[] = ids.split(",");
		for(String id: idArray){
			testActivitiAuditService.removeById ( id );
		}
		return ResponseEntity.ok( "删除薪酬调整申请成功" );
	}

}
