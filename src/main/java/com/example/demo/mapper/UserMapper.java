package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;

import java.util.List;

public interface UserMapper {
    UserDTO entityToDto(User user);
    User dtoToEntity(UserDTO userDto);
    List<UserDTO> entitiesToDtos(List<User> users);
}
