/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.service.mapstruct;


import com.jeeplus.core.mapstruct.EntityWrapper;
import com.jeeplus.test.activiti.service.dto.TestActivitiLeaveDTO;
import com.jeeplus.test.activiti.domain.TestActivitiLeave;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *  TestActivitiLeaveWrapper
 * @author liugf
 * @version 2022-03-20
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {} )
public interface TestActivitiLeaveWrapper extends EntityWrapper<TestActivitiLeaveDTO, TestActivitiLeave> {

    TestActivitiLeaveWrapper INSTANCE = Mappers.getMapper(TestActivitiLeaveWrapper.class);
     @Mappings({
            @Mapping(source = "createBy.id", target = "createBy"),
            @Mapping (source = "updateBy.id", target = "updateBy")})
    TestActivitiLeave toEntity(TestActivitiLeaveDTO dto);


    @Mappings({
            @Mapping (source = "createBy", target = "createBy.id"),
            @Mapping (source = "updateBy", target = "updateBy.id")})
    TestActivitiLeaveDTO toDTO(TestActivitiLeave entity);
}

