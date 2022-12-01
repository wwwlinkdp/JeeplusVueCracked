package com.jeeplus.sys.service.mapstruct;

import com.jeeplus.sys.domain.Office;
import com.jeeplus.sys.service.dto.OfficeDTO;
import com.jeeplus.core.mapstruct.TreeWrapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",  unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {})
public interface OfficeWrapper extends TreeWrapper<OfficeDTO, Office> {

    OfficeWrapper INSTANCE = Mappers.getMapper(OfficeWrapper.class);

    /**
     * dto对象转化成entity对象
     */
    @Mappings({
            @Mapping (source = "areaDTO.id", target = "areaId"),
            @Mapping (source = "parent.id", target = "parentId"),
            @Mapping (source = "createBy.id", target = "createBy"),
            @Mapping (source = "updateBy.id", target = "updateBy")})
    Office toEntity(OfficeDTO dto);

    /**
     * entity对象转换成dto对象
     */
    @Mappings({
            @Mapping (source = "areaId", target = "areaDTO.id"),
            @Mapping (source = "parentId", target = "parent.id"),
            @Mapping (source = "createBy", target = "createBy.id"),
            @Mapping (source = "updateBy", target = "updateBy.id")})
    OfficeDTO toDTO(Office entity);

}
