package org.lnu.teaching.web.application.disign.deanery.repository.faculty.impl;

import lombok.AllArgsConstructor;
import org.lnu.teaching.web.application.disign.deanery.dto.faculty.FacultyPatch;
import org.lnu.teaching.web.application.disign.deanery.entity.FacultyEntity;
import org.lnu.teaching.web.application.disign.deanery.exception.NotFoundException;
import org.lnu.teaching.web.application.disign.deanery.repository.faculty.FacultyRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class FacultyRepositoryImpl implements FacultyRepository {

    private static final String INSERT_FACULTY_QUERY = """
            INSERT INTO faculties (
                name,
                website,
                email,
                phone,
                address,
                info
            ) VALUES (
                :name,
                :website,
                :email,
                :phone,
                :address,
                :info
            )
            """;

    private static final String SELECT_FACULTIES_QUERY = """
            SELECT
                id,
                name,
                website,
                email,
                phone,
                address,
                info
            FROM faculties
            """;

    private static final String SELECT_FACULTY_BY_ID_QUERY = """
            SELECT
                id,
                name,
                website,
                email,
                phone,
                address,
                info
            FROM faculties
            WHERE id = :id
            """;

    private static final String UPDATE_FACULTY_BY_ID_QUERY = """
            UPDATE faculties SET
                name = :name,
                website = :website,
                email = :email,
                phone = :phone,
                address = :address,
                info = :info
            WHERE id = :id
            """;

    private static final String PATCH_FACULTY_BY_ID_QUERY_TEMPLATE = """
            UPDATE faculties SET
                %s
            WHERE id = :id
            """;

    private static final String DELETE_FACULTY_BY_ID_QUERY = """
            DELETE FROM faculties WHERE id = :id
            """;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    private static final RowMapper<FacultyEntity> FACULTY_ROW_MAPPER = (rs, rowNum) -> {
        FacultyEntity entity = new FacultyEntity();

        entity.setId(rs.getObject("id", Long.class));
        entity.setName(rs.getString("name"));
        entity.setWebsite(rs.getString("website"));
        entity.setEmail(rs.getString("email"));
        entity.setPhone(rs.getString("phone"));
        entity.setAddress(rs.getString("address"));
        entity.setInfo(rs.getString("info"));

        return entity;
    };


    @Override
    public FacultyEntity create(FacultyEntity faculty) {
        SqlParameterSource sqlParameters = new MapSqlParameterSource()
                .addValue("name", faculty.getName())
                .addValue("website", faculty.getWebsite())
                .addValue("email", faculty.getEmail())
                .addValue("phone", faculty.getPhone())
                .addValue("address", faculty.getAddress())
                .addValue("info", faculty.getInfo());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(INSERT_FACULTY_QUERY, sqlParameters, keyHolder);

        Long id = (Long) keyHolder.getKeys().get("id");
        faculty.setId(id);

        return faculty;
    }

    @Override
    public List<FacultyEntity> findAll() {
        return jdbcTemplate.query(SELECT_FACULTIES_QUERY, FACULTY_ROW_MAPPER);
    }

    @Override
    public FacultyEntity find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_FACULTY_BY_ID_QUERY, new MapSqlParameterSource("id", id), FACULTY_ROW_MAPPER);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundException("Faculty with id " + id + " not found!");
        }
    }

    @Override
    public void update(FacultyEntity faculty) {
        int affectedRows = jdbcTemplate.update(UPDATE_FACULTY_BY_ID_QUERY, new MapSqlParameterSource()
                .addValue("id", faculty.getId())
                .addValue("name", faculty.getName())
                .addValue("website", faculty.getWebsite())
                .addValue("email", faculty.getEmail())
                .addValue("phone", faculty.getPhone())
                .addValue("address", faculty.getAddress())
                .addValue("info", faculty.getInfo()));

        if (affectedRows == 0) {
            throw new NotFoundException("Faculty with id " + faculty.getId() + " not found!");
        }
    }

    @Override
    public void patch(Long id, FacultyPatch facultyPatch) {
        List<String> assignments = new ArrayList<>();
        MapSqlParameterSource parameters = new MapSqlParameterSource("id", id);

        if (facultyPatch.isNameUpdated()) {
            assignments.add("name = :name");
            parameters.addValue("name", facultyPatch.getName());
        }

        if (facultyPatch.isWebsiteUpdated()) {
            assignments.add("website = :website");
            parameters.addValue("website", facultyPatch.getWebsite());
        }

        if (facultyPatch.isEmailUpdated()) {
            assignments.add("email = :email");
            parameters.addValue("email", facultyPatch.getEmail());
        }

        if (facultyPatch.isPhoneUpdated()) {
            assignments.add("phone = :phone");
            parameters.addValue("phone", facultyPatch.getPhone());
        }

        if (facultyPatch.isAddressUpdated()) {
            assignments.add("address = :address");
            parameters.addValue("address", facultyPatch.getAddress());
        }

        if (facultyPatch.isInfoUpdated()) {
            assignments.add("info = :info");
            parameters.addValue("info", facultyPatch.getInfo());
        }

        String assignmentStr = String.join(", ", assignments);
        String query = String.format(PATCH_FACULTY_BY_ID_QUERY_TEMPLATE, assignmentStr);

        int affectedRows = jdbcTemplate.update(query, parameters);

        if (affectedRows == 0) {
            throw new NotFoundException("Faculty with id " + id + " not found!");
        }
    }


    @Override
    public void delete(Long id) {
        int affectedRows = jdbcTemplate.update(DELETE_FACULTY_BY_ID_QUERY, new MapSqlParameterSource("id", id));

        if (affectedRows == 0) {
            throw new NotFoundException("Faculty with id " + id + " not found!");
        }
    }
}
