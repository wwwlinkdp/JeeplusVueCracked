/**
        * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
        */
package com.jeeplus.test.activiti.service.dto;

import com.jeeplus.sys.service.dto.UserDTO;
import javax.validation.constraints.NotNull;
import com.jeeplus.sys.service.dto.OfficeDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.core.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 薪酬调整申请Entity
 * @author liugf
 * @version 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestActivitiAuditDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
     * 流程实例ID
     */
	private String procInsId;
	/**
     * 变动用户
     */
	@NotNull(message="变动用户不能为空")
	private UserDTO user;
	/**
     * 归属部门
     */
	@NotNull(message="归属部门不能为空")
	private OfficeDTO office;
	/**
     * 岗位
     */
	private String post;
	/**
     * 性别
     */
	private String sex;
	/**
     * 学历
     */
	private String edu;
	/**
     * 调整原因
     */
	@NotNull(message="调整原因不能为空")
	private String content;
	/**
     * 现行标准 薪酬档级
     */
	private String olda;
	/**
     * 现行标准 月工资额
     */
	@NotNull(message="现行标准 月工资额不能为空")
	private String oldb;
	/**
     * 现行标准 年薪总额
     */
	private String oldc;
	/**
     * 调整后标准 薪酬档级
     */
	private String newa;
	/**
     * 调整后标准 月工资额
     */
	@NotNull(message="调整后标准 月工资额不能为空")
	private String newb;
	/**
     * 调整后标准 年薪总额
     */
	private String newc;
	/**
     * 月增资
     */
	@NotNull(message="月增资不能为空")
	private String addNum;
	/**
     * 执行时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="执行时间不能为空")
	private Date exeDate;
	/**
     * 备注信息
     */
	private String remarks;

}
