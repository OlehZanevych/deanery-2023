package org.lnu.teaching.web.application.disign.deanery.repository.department;

import org.lnu.teaching.web.application.disign.deanery.entity.department.DepartmentEntity;

import java.util.List;

public interface DepartmentRepository {
    DepartmentEntity create(DepartmentEntity department);
    List<DepartmentEntity> findAll();
}
