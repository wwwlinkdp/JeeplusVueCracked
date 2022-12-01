/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.one.service.dto;

import com.jeeplus.sys.service.dto.OfficeDTO;
import javax.validation.constraints.NotNull;
import com.jeeplus.sys.service.dto.UserDTO;
import com.jeeplus.sys.service.dto.AreaDTO;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.jeeplus.core.query.Query;
import com.jeeplus.core.query.QueryType;
import com.jeeplus.core.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * 请假表单DTO
 * @author 刘高峰
 * @version 2022-04-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TestFormLeaveDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/**
     * 所属公司
     */
	@NotNull(message="所属公司不能为空")
	private OfficeDTO company;
	/**
     * 归属部门
     */
	@NotNull(message="归属部门不能为空")
    @Query(tableColumn = "a.office_id", javaField = "office.id", type = QueryType.EQ)
	private OfficeDTO office;
	/**
     * 员工
     */
    @Query(tableColumn = "a.user_id", javaField = "user.id", type = QueryType.EQ)
	private UserDTO user;
	/**
     * 归属区域
     */
    @Query(tableColumn = "a.area_id", javaField = "area.id", type = QueryType.EQ)
	private AreaDTO area;
	/**
     * 请假开始日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Query(tableColumn = "a.begin_date", javaField = "beginDate", type = QueryType.BETWEEN)
	private Date beginDate;
	/**
     * 请假结束日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Query(tableColumn = "a.end_date", javaField = "endDate", type = QueryType.NOTBETWEEN)
	private Date endDate;

}
