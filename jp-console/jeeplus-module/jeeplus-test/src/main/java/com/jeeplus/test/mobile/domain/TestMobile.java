/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jeeplus.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 测试移动表单Entity
 * @author 刘高峰
 * @version 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("test_mobile")
public class TestMobile extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
     * 姓名
     */
	private String name;
	/**
     * 年龄
     */
	private String age;
	/**
     * 地区
     */
	private String areaId;
	/**
     * 公司
     */
	private String companyId;
	/**
     * 部门
     */
	private String officeId;
	/**
     * 性别
     */
	private String sex;
	/**
     * 头像
     */
	private String teImage;
	/**
     * 单选框
     */
	private String isSingle;
	/**
     * 多选框
     */
	private String cks;
	/**
     * 多行文本框
     */
	private String textArea;
	/**
     * 数字输入框
     */
	private String textNumber;
	/**
     * 日期选择框
     */
	private Date teDate;
	/**
     * 邮箱
     */
	private String email;
	/**
     * 手机号
     */
	private String phone;
	/**
     * 电话
     */
	private String tel;

}
