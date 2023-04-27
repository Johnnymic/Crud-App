package com.example.classactivity.controller;

import com.example.classactivity.dTO.UserDto;
import com.example.classactivity.service.UserService;
import com.example.classactivity.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @PostMapping()
    private ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto respond = userService.createUser(userDto);
      return   new ResponseEntity<UserDto>(respond, HttpStatus.CREATED);
    }

    @GetMapping()
    private  ResponseEntity<List<UserDto>>getAllUser(){
        List<UserDto> respond = userService.findAllUser();
        return   new ResponseEntity<>(respond,HttpStatus.OK);
    }

    @GetMapping("/{Id}")
    private ResponseEntity<UserDto>getUser(@PathVariable("Id") Long Id){
        UserDto respond = userService.findUserById(Id);
        return new ResponseEntity<>(respond,HttpStatus.OK);

    }
    @PutMapping("/{Id}")
    private ResponseEntity<UserDto> updateUser(@PathVariable("Id") Long Id, @RequestBody UserDto userDto){
         UserDto respond = userService.updateUser(Id,userDto);
         return new ResponseEntity<>(respond,HttpStatus.FOUND);
    }

    @DeleteMapping("/{Id}")
    private ResponseEntity<?> deleteUser(@PathVariable("Id") Long Id){
        userService.deleteUser(Id);
        return new ResponseEntity<>("User is succesfully deleted",HttpStatus.OK);
    }


}
