package org.lnu.teaching.web.application.disign.deanery.service.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.disign.deanery.entity.FacultyEntity;
import org.lnu.teaching.web.application.disign.deanery.mapper.FacultyMapper;
import org.lnu.teaching.web.application.disign.deanery.repository.faculty.FacultyRepository;
import org.lnu.teaching.web.application.disign.deanery.service.faculty.FacultyService;
import org.springframework.stereotype.Service;

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
    public List<FacultyDto> findAll() {
        List<FacultyEntity> facultyEntities = facultyRepository.findAll();
        return facultyMapper.toDtoList(facultyEntities);
    }

    @Override
    public FacultyDto find(Long id) {
        FacultyEntity facultyEntity = facultyRepository.find(id);
        return facultyMapper.toDto(facultyEntity);
    }

    @Override
    public void update(Long id, BaseFacultyDto facultyDto) {
        FacultyEntity facultyEntity = facultyMapper.toEntity(facultyDto);
        facultyEntity.setId(id);

        facultyRepository.update(facultyEntity);
    }

    @Override
    public void delete(Long id) {
        facultyRepository.delete(id);
    }
}
