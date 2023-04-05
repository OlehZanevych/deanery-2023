package org.lnu.teaching.web.application.disign.deanery.mapper;


import org.lnu.teaching.web.application.disign.deanery.dto.user.UserCreateDto;
import org.lnu.teaching.web.application.disign.deanery.dto.user.UserDto;
import org.lnu.teaching.web.application.disign.deanery.entity.user.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserEntity toEntity(UserCreateDto userDto);
    UserDto toDto(UserEntity userEntity);
    List<UserDto> toDtoList(List<UserEntity> userEntities);
}
