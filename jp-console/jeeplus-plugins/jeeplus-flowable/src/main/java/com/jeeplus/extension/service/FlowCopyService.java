/**
 * Copyright © 2021-2026 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.extension.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeeplus.extension.domain.FlowCopy;
import com.jeeplus.extension.mapper.FlowCopyMapper;
import com.jeeplus.extension.service.dto.FlowCopyDTO;
import com.jeeplus.sys.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 流程抄送Service
 * @author 刘高峰
 * @version 2021-09-10
 */
@Service
@Transactional
public class FlowCopyService extends ServiceImpl <FlowCopyMapper, FlowCopy> {

    public IPage <FlowCopyDTO> findPage (Page <FlowCopyDTO> page, QueryWrapper <FlowCopyDTO> queryWrapper) {
        queryWrapper.eq ( "a.del_flag", 0 ); //排除已删除
        queryWrapper.eq ( "a.user_id", UserUtils.getCurrentUserDTO ().getId () ); //排除已删除
        return baseMapper.findList (page, queryWrapper  );
    }

}
