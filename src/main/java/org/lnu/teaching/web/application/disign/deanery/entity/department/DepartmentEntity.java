package org.lnu.teaching.web.application.disign.deanery.entity.department;

import lombok.Data;
import org.lnu.teaching.web.application.disign.deanery.entity.faculty.FacultyEntity;

@Data
public class DepartmentEntity {
    private Long id;
    private FacultyEntity faculty;
    private String name;
    private String email;
    private String phone;
    private String info;
}

