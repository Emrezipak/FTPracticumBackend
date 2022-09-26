package com.java.practicumfinalcase.controller;

import com.java.practicumfinalcase.entity.Admin;
import com.java.practicumfinalcase.payload.request.LoginRequest;
import com.java.practicumfinalcase.payload.response.UserResponse;
import com.java.practicumfinalcase.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest){

    }
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody Admin user){
        return ResponseEntity.ok(userService.save(user));
    }
}
