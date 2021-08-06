package ru.supreme.webdemo.service.impl;

import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.dto.UserDTO;
import ru.supreme.webdemo.model.entity.UserEntity;

@Component
public class UserMapper {

    public UserDTO entityToDTO(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return new UserDTO(userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getId());
    }

    public UserEntity dtoToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        return new UserEntity(userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword());
    }
}
