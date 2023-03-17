package org.lnu.teaching.web.application.disign.deanery.mapper;

import org.lnu.teaching.web.application.disign.deanery.dto.department.BaseDepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentItemDto;
import org.lnu.teaching.web.application.disign.deanery.entity.department.DepartmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mapping(target="faculty.id", source="facultyId")
    DepartmentEntity toEntity(BaseDepartmentDto departmentDto);
    @Mapping(target="facultyId", source="faculty.id")
    DepartmentDto toDto(DepartmentEntity departmentEntity);
    List<DepartmentDto> toDtoList(List<DepartmentEntity> departmentEntities);

    @Mapping(target="facultyId", source="faculty.id")
    @Mapping(target="facultyName", source="faculty.name")
    DepartmentItemDto toDepartmentItem(DepartmentEntity departmentEntity);

    List<DepartmentItemDto> toDepartmentItems(List<DepartmentEntity> departmentEntities);
}