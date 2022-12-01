/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.manytomany.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jeeplus.test.manytomany.domain.Course;
import com.jeeplus.test.manytomany.mapper.CourseMapper;

/**
 * 课程Service
 * @author lgf
 * @version 2022-03-18
 */
@Service
@Transactional
public class CourseService extends ServiceImpl<CourseMapper, Course> {

}
