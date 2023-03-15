package org.lnu.teaching.web.application.disign.deanery.controller.faculty;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.common.ValueDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.query.params.FacultyFitterOptions;
import org.lnu.teaching.web.application.disign.deanery.service.faculty.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("faculties")
public class FacultyController {

    private final FacultyService facultyService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public FacultyDto create(@RequestBody BaseFacultyDto faculty) {
        return facultyService.create(faculty);
    }

    @GetMapping
    public List<FacultyDto> findAll(FacultyFitterOptions fitterOptions, Integer limit, Integer offset) {
        return facultyService.findAll(fitterOptions, limit, offset);
    }

    @GetMapping("{id}")
    public FacultyDto find(@PathVariable Long id) {
        return facultyService.find(id);
    }

    @GetMapping("count")
    public ValueDto<Integer> count(FacultyFitterOptions params) {
        return facultyService.count(params);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody BaseFacultyDto faculty) {
        facultyService.update(id, faculty);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patch(@PathVariable Long id, @RequestBody FacultyPatch facultyPatch) {
        facultyService.patch(id, facultyPatch);
    }

    @DeleteMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        facultyService.delete(id);
    }
}
