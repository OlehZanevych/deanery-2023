package org.lnu.teaching.web.application.disign.deanery.service.department;

import org.lnu.teaching.web.application.disign.deanery.dto.department.BaseDepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentItemDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto create(BaseDepartmentDto department);
    List<DepartmentItemDto> findAll();
}
