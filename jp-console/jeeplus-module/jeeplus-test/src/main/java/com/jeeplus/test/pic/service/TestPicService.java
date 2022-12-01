/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.pic.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeeplus.test.pic.domain.TestPic;
import com.jeeplus.test.pic.mapper.TestPicMapper;

/**
 * 图片管理Service
 * @author lgf
 * @version 2022-03-18
 */
@Service
@Transactional
public class TestPicService extends ServiceImpl<TestPicMapper, TestPic> {

}
