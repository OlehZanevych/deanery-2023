package org.lnu.teaching.web.application.disign.deanery.service.user.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserUpdateDto;
import org.lnu.teaching.web.application.disign.deanery.entity.user.UserEntity;
import org.lnu.teaching.web.application.disign.deanery.exception.DataConflictException;
import org.lnu.teaching.web.application.disign.deanery.exception.NotFoundException;
import org.lnu.teaching.web.application.disign.deanery.mapper.UserMapper;
import org.lnu.teaching.web.application.disign.deanery.repository.user.UserRepository;
import org.lnu.teaching.web.application.disign.deanery.service.user.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDto create(UserCreateDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);

        String passwordHash = bCryptPasswordEncoder.encode(userDto.getPassword());
        userEntity.setPasswordHash(passwordHash);

        try {
            userEntity = userRepository.save(userEntity);
        } catch (DataIntegrityViolationException e) {
            Throwable cause = e.getCause();
            if (cause instanceof ConstraintViolationException) {
                if ("users_username_key".equals(((ConstraintViolationException) cause).getConstraintName())) {
                    String errorMessage = String.format("User with username '%s' already exists!", userEntity.getUsername());
                    throw new DataConflictException(errorMessage);
                }
            }

            throw e;
        }
        return userMapper.toDto(userEntity);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userMapper.toDtoList(userEntities);
    }

    @Override
    public UserDto find(Long id) {
        UserEntity userEntity = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found!"));
        return userMapper.toDto(userEntity);
    }

    @Override
    public void update(Long id, UserUpdateDto userDto) {
        // Home task
    }

    @Override
    @Transactional
    public void delete(Long id) {
        int affectedRaws = userRepository.removeById(id);
        if (affectedRaws == 0) {
            throw new NotFoundException("User not found!");
        }
    }
}
