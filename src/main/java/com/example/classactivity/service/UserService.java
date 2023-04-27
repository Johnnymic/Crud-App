package com.example.classactivity.service;

import com.example.classactivity.dTO.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    List<UserDto> findAllUser();

    UserDto findUserById(Long userId);

    UserDto updateUser(Long userId , UserDto userDto);

    void deleteUser(Long Id);

}
