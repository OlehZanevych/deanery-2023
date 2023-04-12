package org.lnu.teaching.web.application.disign.deanery.service.faculty.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.BaseFacultyDto;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyDto;
import org.lnu.teaching.web.application.disign.deanery.entity.faculty.FacultyEntity;
import org.lnu.teaching.web.application.disign.deanery.mapper.FacultyMapper;
import org.lnu.teaching.web.application.disign.deanery.repository.faculty.FacultyRepository;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FacultyServiceImplTest {

    @Mock
    private FacultyRepository facultyRepository;

    @Mock
    private FacultyMapper facultyMapper;

    @InjectMocks
    private FacultyServiceImpl facultyService;

    @Test
    public void create() {
        // Given
        Long createdFacultyId = 100L;

        FacultyDto expectedFacultyDto = new FacultyDto();
        expectedFacultyDto.setId(createdFacultyId);

        // When
        BaseFacultyDto baseFacultyDto = new BaseFacultyDto();

        FacultyEntity mappedFacultyEntity = new FacultyEntity();
        FacultyEntity createdFacultyEntity = new FacultyEntity();

        when(facultyMapper.toEntity(baseFacultyDto)).thenReturn(mappedFacultyEntity);
        when(facultyRepository.create(mappedFacultyEntity)).thenReturn(createdFacultyEntity);
        when(facultyMapper.toDto(createdFacultyEntity)).thenReturn(expectedFacultyDto);

        FacultyDto actualFacultyDto = facultyService.create(baseFacultyDto);

        // Then
        assertEquals(actualFacultyDto, expectedFacultyDto);

        InOrder inOrder = inOrder(facultyRepository, facultyMapper);
        inOrder.verify(facultyMapper).toEntity(baseFacultyDto);
        inOrder.verify(facultyRepository).create(mappedFacultyEntity);
        inOrder.verify(facultyMapper).toDto(createdFacultyEntity);
        inOrder.verifyNoMoreInteractions();
    }
}
