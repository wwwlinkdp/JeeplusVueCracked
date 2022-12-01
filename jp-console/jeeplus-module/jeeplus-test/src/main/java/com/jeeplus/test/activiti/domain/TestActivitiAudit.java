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
 * 薪酬调整申请Entity
 * @author liugf
 * @version 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_activiti_audit")
public class TestActivitiAudit extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 流程实例ID
     */
	private String procInsId;
	/**
     * 变动用户
     */
	private String userId;
	/**
     * 归属部门
     */
	private String officeId;
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
	private String content;
	/**
     * 现行标准 薪酬档级
     */
	private String olda;
	/**
     * 现行标准 月工资额
     */
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
	private String newb;
	/**
     * 调整后标准 年薪总额
     */
	private String newc;
	/**
     * 月增资
     */
	private String addNum;
	/**
     * 执行时间
     */
	private Date exeDate;
	/**
     * 备注信息
     */
	private String remarks;

}
