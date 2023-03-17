package org.lnu.teaching.web.application.disign.deanery.service.department;

import org.lnu.teaching.web.application.disign.deanery.dto.department.BaseDepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentDto;

public interface DepartmentService {
    DepartmentDto create(BaseDepartmentDto department);
}
