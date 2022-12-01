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
import com.jeeplus.test.activiti.service.dto.TestActivitiAuditDTO;
import com.jeeplus.test.activiti.domain.TestActivitiAudit;

/**
 * 薪酬调整申请MAPPER接口
 * @author liugf
 * @version 2022-03-20
 */
public interface TestActivitiAuditMapper extends BaseMapper<TestActivitiAudit> {

    /**
     * 根据id获取薪酬调整申请
     * @param id
     * @return
     */
    TestActivitiAuditDTO findById(String id);

    /**
     * 获取薪酬调整申请列表
     *
     * @param queryWrapper
     * @return
     */
    IPage <TestActivitiAuditDTO> findList(Page <TestActivitiAuditDTO> page, @Param(Constants.WRAPPER) QueryWrapper queryWrapper);

}
