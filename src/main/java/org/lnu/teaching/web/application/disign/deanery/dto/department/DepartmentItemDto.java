package org.lnu.teaching.web.application.disign.deanery.dto.department;

import lombok.Data;

@Data
public class DepartmentItemDto {
    private Long id;
    private String name;
    private Long facultyId;
    private String facultyName;
}
