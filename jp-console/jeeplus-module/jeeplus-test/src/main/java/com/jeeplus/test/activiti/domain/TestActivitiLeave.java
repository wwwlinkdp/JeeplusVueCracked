/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jeeplus.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 请假申请Entity
 * @author liugf
 * @version 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_activiti_leave")
public class TestActivitiLeave extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 流程实例ID
     */
	private String procInsId;
	/**
     * 请假类型
     */
	private String leaveType;
	/**
     * 请假开始时间
     */
	private Date startTime;
	/**
     * 请假结束时间
     */
	private Date endTime;
	/**
     * 请假事由
     */
	private String reason;
	/**
     * 备注信息
     */
	private String remarks;

}
