/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jeeplus.test.activiti.service.dto.TestActivitiExpenseDTO;
import com.jeeplus.test.activiti.domain.TestActivitiExpense;

/**
 * 报销申请MAPPER接口
 * @author liugf
 * @version 2022-03-20
 */
public interface TestActivitiExpenseMapper extends BaseMapper<TestActivitiExpense> {

    /**
     * 根据id获取报销申请
     * @param id
     * @return
     */
    TestActivitiExpenseDTO findById(String id);

    /**
     * 获取报销申请列表
     *
     * @param queryWrapper
     * @return
     */
    IPage <TestActivitiExpenseDTO> findList(Page <TestActivitiExpenseDTO> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
