package org.lnu.teaching.web.application.disign.deanery.service.department.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.department.BaseDepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentItemDto;
import org.lnu.teaching.web.application.disign.deanery.entity.department.DepartmentEntity;
import org.lnu.teaching.web.application.disign.deanery.mapper.DepartmentMapper;
import org.lnu.teaching.web.application.disign.deanery.repository.department.DepartmentRepository;
import org.lnu.teaching.web.application.disign.deanery.service.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto create(BaseDepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = departmentMapper.toEntity(departmentDto);
        DepartmentEntity createdDepartmentEntity = departmentRepository.create(departmentEntity);
        return departmentMapper.toDto(createdDepartmentEntity);
    }

    @Override
    public List<DepartmentItemDto> findAll() {
        return departmentMapper.toDepartmentItems(departmentRepository.findAll());
    }
}
