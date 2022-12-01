/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.service.dto;

import javax.validation.constraints.NotNull;
import com.jeeplus.sys.service.dto.AreaDTO;
import com.jeeplus.sys.service.dto.OfficeDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.core.query.Query;
import com.jeeplus.core.query.QueryType;
import com.jeeplus.core.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 测试移动表单DTO
 * @author 刘高峰
 * @version 2022-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestMobileDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
     * 姓名
     */
	@NotNull(message="姓名不能为空")
    @Query(tableColumn = "a.name", javaField = "name", type = QueryType.LIKE)
	private String name;
	/**
     * 年龄
     */
	@NotNull(message="年龄不能为空")
    @Query(tableColumn = "a.age", javaField = "age", type = QueryType.EQ)
	private String age;
	/**
     * 地区
     */
	@NotNull(message="地区不能为空")
    @Query(tableColumn = "a.area_id", javaField = "area.id", type = QueryType.EQ)
	private AreaDTO area;
	/**
     * 公司
     */
	@NotNull(message="公司不能为空")
    @Query(tableColumn = "a.company_id", javaField = "company.id", type = QueryType.EQ)
	private OfficeDTO company;
	/**
     * 部门
     */
	@NotNull(message="部门不能为空")
    @Query(tableColumn = "a.office_id", javaField = "office.id", type = QueryType.EQ)
	private OfficeDTO office;
	/**
     * 性别
     */
	@NotNull(message="性别不能为空")
    @Query(tableColumn = "a.sex", javaField = "sex", type = QueryType.EQ)
	private String sex;
	/**
     * 头像
     */
	@NotNull(message="头像不能为空")
    @Query(tableColumn = "a.te_image", javaField = "teImage", type = QueryType.EQ)
	private String teImage;
	/**
     * 单选框
     */
	@NotNull(message="单选框不能为空")
    @Query(tableColumn = "a.is_single", javaField = "isSingle", type = QueryType.EQ)
	private String isSingle;
	/**
     * 多选框
     */
	@NotNull(message="多选框不能为空")
    @Query(tableColumn = "a.cks", javaField = "cks", type = QueryType.EQ)
	private String cks;
	/**
     * 多行文本框
     */
	@NotNull(message="多行文本框不能为空")
    @Query(tableColumn = "a.text_area", javaField = "textArea", type = QueryType.EQ)
	private String textArea;
	/**
     * 数字输入框
     */
	@NotNull(message="数字输入框不能为空")
    @Query(tableColumn = "a.text_number", javaField = "textNumber", type = QueryType.EQ)
	private String textNumber;
	/**
     * 日期选择框
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="日期选择框不能为空")
    @Query(tableColumn = "a.te_date", javaField = "teDate", type = QueryType.EQ)
	private Date teDate;
	/**
     * 邮箱
     */
    @Query(tableColumn = "a.email", javaField = "email", type = QueryType.EQ)
	private String email;
	/**
     * 手机号
     */
    @Query(tableColumn = "a.phone", javaField = "phone", type = QueryType.EQ)
	private String phone;
	/**
     * 电话
     */
    @Query(tableColumn = "a.tel", javaField = "tel", type = QueryType.EQ)
	private String tel;

}
