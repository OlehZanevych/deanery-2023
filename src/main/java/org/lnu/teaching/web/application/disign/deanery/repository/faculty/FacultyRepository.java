package org.lnu.teaching.web.application.disign.deanery.repository.faculty;

import org.lnu.teaching.web.application.disign.deanery.entity.FacultyEntity;

import java.util.List;

public interface FacultyRepository {
    FacultyEntity create(FacultyEntity faculty);
    List<FacultyEntity> findAll();
    FacultyEntity find(Long id);
    void update(FacultyEntity faculty);
    void delete(Long id);
}
