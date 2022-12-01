/**
 * Copyright © 2021-2025 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.jeeplus.test.mobile.service.mapstruct;


import com.jeeplus.core.mapstruct.EntityWrapper;
import com.jeeplus.test.mobile.service.dto.TestMobileDTO;
import com.jeeplus.test.mobile.domain.TestMobile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 *  TestMobileWrapper
 * @author 刘高峰
 * @version 2022-04-13
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {} )
public interface TestMobileWrapper extends EntityWrapper<TestMobileDTO, TestMobile> {

    TestMobileWrapper INSTANCE = Mappers.getMapper(TestMobileWrapper.class);
     @Mappings({
            @Mapping(source = "area.id", target = "areaId"),
            @Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "office.id", target = "officeId"),
            @Mapping(source = "createBy.id", target = "createBy"),
            @Mapping (source = "updateBy.id", target = "updateBy")})
    TestMobile toEntity(TestMobileDTO dto);


    @Mappings({
            @Mapping(source = "areaId", target = "area.id"),
            @Mapping(source = "companyId", target = "company.id"),
            @Mapping(source = "officeId", target = "office.id"),
            @Mapping (source = "createBy", target = "createBy.id"),
            @Mapping (source = "updateBy", target = "updateBy.id")})
    TestMobileDTO toDTO(TestMobile entity);
}

