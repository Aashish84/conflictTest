package com.example.demo.services.serviceImpl;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.models.User;
import com.example.demo.repo.UserRepo;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    @Override
    public List<UserDTO> getUser() {
        List<User> all = userRepo.findAll();
        return userMapper.entitiesToDtos(all);
    }

    @Override
    public UserDTO getUser(long id) {
        Optional<User> user = userRepo.findById(id);
        return user.map(userMapper::entityToDto).orElse(null);
    }

    @Override
    public UserDTO saveData(UserDTO userDTO) {
        User user = userMapper.dtoToEntity(userDTO);
        return userMapper.entityToDto(userRepo.save(user));
    }

    @Override
    public List<UserDTO> getUserByPage(int size , int pageNo) {
        return userMapper.entitiesToDtos(userRepo.findUserByPage(size,pageNo));
    }
}
