package org.lnu.teaching.web.application.disign.deanery.repository.faculty;

import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.disign.deanery.entity.FacultyEntity;

import java.util.List;

public interface FacultyRepository {
    FacultyEntity create(FacultyEntity faculty);
    List<FacultyEntity> findAll();
    FacultyEntity find(Long id);
    void update(FacultyEntity faculty);
    void patch(Long id, FacultyPatch facultyPatch);
    void delete(Long id);
}
