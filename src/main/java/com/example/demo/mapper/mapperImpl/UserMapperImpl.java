package com.example.demo.mapper.mapperImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDTO entityToDto(User user) {
        if (user == null)
            return null;

        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setUserName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setLocked(user.isLocked());

        return userDto;
    }

    @Override
    public User dtoToEntity(UserDTO userDto) {
        if (userDto == null)
            return null;

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setLocked(userDto.isLocked());

        return user;
    }

    @Override
    public List<UserDTO> entitiesToDtos(List<User> users) {

        if (users == null)
            return null;

        List<UserDTO> userDtos = new ArrayList<>();
        for(User u : users){
            UserDTO userDto = entityToDto(u);
            userDtos.add(userDto);
        }

        return userDtos;
    }
}
