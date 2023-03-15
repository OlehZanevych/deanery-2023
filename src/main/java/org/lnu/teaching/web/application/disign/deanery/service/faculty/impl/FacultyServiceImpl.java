package org.lnu.teaching.web.application.disign.deanery.service.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.common.ValueDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.query.params.FacultyFitterOptions;
import org.lnu.teaching.web.application.disign.deanery.entity.FacultyEntity;
import org.lnu.teaching.web.application.disign.deanery.exception.BadRequestException;
import org.lnu.teaching.web.application.disign.deanery.mapper.FacultyMapper;
import org.lnu.teaching.web.application.disign.deanery.repository.faculty.FacultyRepository;
import org.lnu.teaching.web.application.disign.deanery.service.faculty.FacultyService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    private final FacultyMapper facultyMapper;

    @Override
    public FacultyDto create(BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        FacultyEntity createdFacultyEntity = facultyRepository.create(facultyEntity);
        return facultyMapper.toDto(createdFacultyEntity);
    }

    @Override
    public List<FacultyDto> findAll(@RequestParam(required = false) FacultyFitterOptions fitterOptions, @RequestParam(defaultValue = "100", required = false) Integer limit, @RequestParam(defaultValue = "0", required = false) Integer offset) {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll(fitterOptions, limit, offset);
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    public FacultyDto find(Long id) {
        FacultyEntity facultyEntity = facultyRepository.find(id);
        return facultyMapper.toDto(facultyEntity);
    }

    @Override
    public ValueDto<Integer> count(FacultyFitterOptions params) {
        int count = facultyRepository.count(params);
        return new ValueDto<>(count);
    }

    @Override
    public void update(Long id, BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        facultyEntity.setId(id);

        facultyRepository.update(facultyEntity);
    }

    @Override
    public void patch(Long id, FacultyPatch facultyPatch) {
        if (facultyPatch.isEmpty()) {
            throw new BadRequestException("Faculty patch is empty!");
        }

        facultyRepository.patch(id, facultyPatch);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}
