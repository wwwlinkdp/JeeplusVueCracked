/**
 * Copyright © 2021-2026 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.extension.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jeeplus.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 节点设置Entity
 * @author 刘高峰
 * @version 2021-01-11
 */



@Data
@EqualsAndHashCode(callSuper = false)
@TableName("act_extension_node_setting")
public class NodeSetting extends BaseEntity {

	private static final long serialVersionUID = 1L;
	/**
	 * 流程定义id
	 */
	private String processDefId;
	/**
	 * 节点id
	 */
	private String taskDefId;
	/**
	 * 变量名
	 */
	@JsonIgnore
	private String nodeKey;
	/**
	 * 变量值
	 */
	@JsonIgnore
	private String nodeValue;

	public NodeSetting() {
		super();
	}

	public String getKey(){
		return this.nodeKey;
	}
	public void setKey(String key){
		this.nodeKey = key;
	}
	public String getValue(){
		return this.nodeValue;
	}
	public void setValue(String value){
		this.nodeValue = value;
	}
}
