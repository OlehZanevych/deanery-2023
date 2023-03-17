package org.lnu.teaching.web.application.disign.deanery.dto.department;

import lombok.Data;

@Data
public class BaseDepartmentDto {
    private Long facultyId;
    private String name;
    private String email;
    private String phone;
    private String info;
}
