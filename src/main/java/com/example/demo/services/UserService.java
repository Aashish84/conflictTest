package com.example.demo.services;

import com.example.demo.dto.UserDTO;
import com.example.demo.models.User;

import java.util.List;

public interface UserService {
    List<UserDTO> getUser();
    UserDTO getUser(long id);
    UserDTO saveData(UserDTO userDTO);
    List<UserDTO> getUserByPage(int size , int pageNo);
}
