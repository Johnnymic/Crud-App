package com.example.classactivity.service.Imp;

import com.example.classactivity.repository.UserRepository;
import com.example.classactivity.service.UserService;
import com.example.classactivity.user.User;
import com.example.classactivity.dTO.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
       User user = mapToUser(userDto);

       User createdUser = userRepository.save(user);
       return mapToDto(createdUser);
    }

    @Override
    public List<UserDto> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NullPointerException("USER OT FOUND"));
        return mapToDto(user) ;
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NullPointerException("USER OT FOUND"));
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
                user.setPassword(userDto.getPassword());
                User saveUser = userRepository.save(user);
                return mapToDto(saveUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NullPointerException("USER OT FOUND"));
          userRepository.delete(user);
    }

    private  UserDto mapToDto(User user){
         UserDto userDto = UserDto.builder()
                 .email(user.getEmail())
                 .password(user.getPassword())
                 .username(user.getUsername())
                 .build();
         return userDto;

    }

    private User mapToUser(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .username(userDto.getUsername())
                .build();
        return user;
    }





}
