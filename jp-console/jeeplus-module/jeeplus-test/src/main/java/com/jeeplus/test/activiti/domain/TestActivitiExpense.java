/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jeeplus.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 报销申请Entity
 * @author liugf
 * @version 2022-03-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_activiti_expense")
public class TestActivitiExpense extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 员工姓名
     */
    @TableField("name")
	private String userId;
	/**
     * 流程实例ID
     */
	private String procInsId;
	/**
     * 报销费用
     */
	private Integer cost;
	/**
     * 归属部门
     */
	private String officeId;
	/**
     * 报销事由
     */
	private String reason;
	/**
     * 备注信息
     */
	private String remarks;

}
