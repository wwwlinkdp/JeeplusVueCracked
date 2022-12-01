/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.activiti.service.mapstruct;


import com.jeeplus.core.mapstruct.EntityWrapper;
import com.jeeplus.test.activiti.service.dto.TestActivitiAuditDTO;
import com.jeeplus.test.activiti.domain.TestActivitiAudit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *  TestActivitiAuditWrapper
 * @author liugf
 * @version 2022-03-20
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {} )
public interface TestActivitiAuditWrapper extends EntityWrapper<TestActivitiAuditDTO, TestActivitiAudit> {

    TestActivitiAuditWrapper INSTANCE = Mappers.getMapper(TestActivitiAuditWrapper.class);
     @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "office.id", target = "officeId"),
            @Mapping(source = "createBy.id", target = "createBy"),
            @Mapping (source = "updateBy.id", target = "updateBy")})
    TestActivitiAudit toEntity(TestActivitiAuditDTO dto);


    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "officeId", target = "office.id"),
            @Mapping (source = "createBy", target = "createBy.id"),
            @Mapping (source = "updateBy", target = "updateBy.id")})
    TestActivitiAuditDTO toDTO(TestActivitiAudit entity);
}

