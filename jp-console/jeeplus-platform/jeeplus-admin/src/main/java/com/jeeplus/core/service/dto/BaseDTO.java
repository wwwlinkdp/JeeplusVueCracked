package com.jeeplus.core.service.dto;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.jeeplus.config.swagger.IgnoreSwaggerParameter;
import com.jeeplus.sys.service.dto.UserDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public abstract class BaseDTO <T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体主键
     */
    @ExcelIgnore
    protected String id;

    /**
     * 创建日期
     */
    @IgnoreSwaggerParameter
    @ExcelIgnore
    protected Date createDate;

    /**
     * 创建人
     */
    @IgnoreSwaggerParameter
    @ExcelIgnore
    protected UserDTO createBy;

    /**
     * 更新日期
     */
    @IgnoreSwaggerParameter
    @ExcelIgnore
    protected Date updateDate;

    /**
     * 更新人
     */
    @IgnoreSwaggerParameter
    @ExcelIgnore
    protected UserDTO updateBy;

    /**
     * 逻辑删除标记
     */
    @IgnoreSwaggerParameter
    @ExcelIgnore
    protected Integer delFlag;

    /**
     * 构造函数
     */
    public BaseDTO () {

    }

    /**
     * 构造函数
     * @param id
     */
    public BaseDTO (String id) {
        this.id = id;
    }



}

