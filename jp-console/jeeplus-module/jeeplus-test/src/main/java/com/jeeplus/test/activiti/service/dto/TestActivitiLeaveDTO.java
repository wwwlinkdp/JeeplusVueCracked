/**
        * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
        */
package com.jeeplus.test.activiti.service.dto;

import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.core.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 请假申请Entity
 * @author liugf
 * @version 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestActivitiLeaveDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
     * 流程实例ID
     */
	private String procInsId;
	/**
     * 请假类型
     */
	@NotNull(message="请假类型不能为空")
	private String leaveType;
	/**
     * 请假开始时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="请假开始时间不能为空")
	private Date startTime;
	/**
     * 请假结束时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="请假结束时间不能为空")
	private Date endTime;
	/**
     * 请假事由
     */
	@NotNull(message="请假事由不能为空")
	private String reason;
	/**
     * 备注信息
     */
	private String remarks;

}
