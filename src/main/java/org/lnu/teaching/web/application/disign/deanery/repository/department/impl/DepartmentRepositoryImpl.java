package org.lnu.teaching.web.application.disign.deanery.repository.department.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.entity.department.DepartmentEntity;
import org.lnu.teaching.web.application.disign.deanery.repository.department.DepartmentRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class DepartmentRepositoryImpl implements DepartmentRepository {
    private static final String INSERT_DEPARTMENT_QUERY = """
            INSERT INTO departments (
                name,
                faculty_id,
                email,
                phone,
                info
            ) VALUES (
                :name,
                :facultyId,
                :email,
                :phone,
                :info
            )
            """;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public DepartmentEntity create(DepartmentEntity department) {
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("name", department.getName())
                .addValue("facultyId", department.getFaculty().getId())
                .addValue("email", department.getEmail())
                .addValue("phone", department.getPhone())
                .addValue("info", department.getInfo());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT_DEPARTMENT_QUERY, sqlParameters, keyHolder);

        Long id = (Long) keyHolder.getKeys().get("id");
        department.setId(id);

        return department;
    }
}
