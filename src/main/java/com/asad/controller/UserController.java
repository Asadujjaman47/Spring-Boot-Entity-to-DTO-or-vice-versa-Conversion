package com.asad.controller;

import com.asad.dto.UserLocationDTO;
import com.asad.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllUserLocation() {
        return userService.getAllUsersLocation();
    }
}
