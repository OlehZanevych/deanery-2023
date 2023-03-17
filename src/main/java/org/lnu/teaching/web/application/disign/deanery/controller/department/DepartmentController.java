package org.lnu.teaching.web.application.disign.deanery.controller.department;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.department.BaseDepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.dto.department.DepartmentDto;
import org.lnu.teaching.web.application.disign.deanery.service.department.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDto create(@RequestBody BaseDepartmentDto department) {
        return departmentService.create(department);
    }
}
