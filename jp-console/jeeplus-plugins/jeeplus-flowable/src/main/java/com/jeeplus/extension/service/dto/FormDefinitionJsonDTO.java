/**
 * Copyright © 2021-2026 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.extension.service.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeeplus.core.service.dto.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 流程表单Entity
 * @author 刘高峰
 * @version 2021-02-02
 */


@Data
@EqualsAndHashCode(callSuper = false)
public class FormDefinitionJsonDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	/**
	 * 表单定义id
	 */
	private String formDefinitionId;
	/**
	 * 流程表单结构体
	 */
	@JsonIgnore
	private String jsonBody;
	private Integer version;		// 版本号
	private String status;		// 状态
	private String isPrimary;		// 是否主版本

	public FormDefinitionJsonDTO() {
		super();
	}

	public FormDefinitionJsonDTO(String id){
		super(id);
	}

	public String getJson() {
		return this.jsonBody;
	}

	public void setJson (String json) {
		this.jsonBody = json;
	}


}
