/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.controller;

import javax.validation.Valid;
import com.google.common.collect.Lists;
import com.jeeplus.core.query.QueryWrapperGenerator;
import com.jeeplus.aop.logging.annotation.ApiLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.mobile.service.dto.TestMobileDTO;
import com.jeeplus.test.mobile.service.mapstruct.TestMobileWrapper;
import com.jeeplus.test.mobile.service.TestMobileService;

/**
 * 测试移动表单Controller
 * @author 刘高峰
 * @version 2022-04-13
 */

@Api(tags ="测试移动表单")
@RestController
@RequestMapping(value = "/test/mobile/testMobile")
public class TestMobileController {

	@Autowired
	private TestMobileService testMobileService;

	@Autowired
	private TestMobileWrapper testMobileWrapper;

	/**
	 * 测试移动表单列表数据
	 */
	@ApiLog("查询测试移动表单列表数据")
	@ApiOperation(value = "查询测试移动表单列表数据")
	@GetMapping("list")
	public ResponseEntity<IPage<TestMobileDTO>> list(TestMobileDTO testMobileDTO, Page<TestMobileDTO> page) throws Exception {
		QueryWrapper queryWrapper = QueryWrapperGenerator.buildQueryCondition (testMobileDTO, TestMobileDTO.class);
		IPage<TestMobileDTO> result = testMobileService.findPage (page, queryWrapper);
		return ResponseEntity.ok (result);
	}


	/**
	 * 根据Id获取测试移动表单数据
	 */
	@ApiLog("根据Id获取测试移动表单数据")
	@ApiOperation(value = "根据Id获取测试移动表单数据")
	@GetMapping("queryById")
	public ResponseEntity<TestMobileDTO> queryById(String id) {
		return ResponseEntity.ok ( testMobileService.findById ( id ) );
	}

	/**
	 * 保存测试移动表单
	 */
	@ApiLog("保存测试移动表单")
	@ApiOperation(value = "保存测试移动表单")
	@PostMapping("save")
	public  ResponseEntity <String> save(@Valid @RequestBody TestMobileDTO testMobileDTO) {
		//新增或编辑表单保存
		testMobileService.saveOrUpdate (testMobileWrapper.toEntity (testMobileDTO));
        return ResponseEntity.ok ( "保存测试移动表单成功" );
	}


	/**
	 * 删除测试移动表单
	 */
	@ApiLog("删除测试移动表单")
	@ApiOperation(value = "删除测试移动表单")
	@DeleteMapping("delete")
	public ResponseEntity <String> delete(String ids) {
		String idArray[] = ids.split(",");
        testMobileService.removeByIds ( Lists.newArrayList ( idArray ) );
		return ResponseEntity.ok( "删除测试移动表单成功" );
	}

}
