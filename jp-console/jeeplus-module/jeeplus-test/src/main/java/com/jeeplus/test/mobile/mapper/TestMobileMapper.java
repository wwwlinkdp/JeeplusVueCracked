/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.mobile.service.dto.TestMobileDTO;
import com.jeeplus.test.mobile.domain.TestMobile;

/**
 * 测试移动表单MAPPER接口
 * @author 刘高峰
 * @version 2022-04-13
 */
public interface TestMobileMapper extends BaseMapper<TestMobile> {

    /**
     * 根据id获取测试移动表单
     * @param id
     * @return
     */
    TestMobileDTO findById(String id);

    /**
     * 获取测试移动表单列表
     *
     * @param queryWrapper
     * @return
     */
    IPage <TestMobileDTO> findList(Page <TestMobileDTO> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
