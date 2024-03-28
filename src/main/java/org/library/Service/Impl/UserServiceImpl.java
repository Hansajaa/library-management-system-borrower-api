package org.library.Service.Impl;

import org.library.Dto.UserDto;
import org.library.Entity.UserEntity;
import org.library.Repository.UserRepository;
import org.library.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean addUser(UserDto dto){
        UserEntity user = modelMapper.map(dto, UserEntity.class);
        userRepository.save(user);
        return true;
    }

    @Override
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }
    @Override
    public boolean deleteUser(Long id){
        userRepository.deleteById(id);
        return true;
    }
}
