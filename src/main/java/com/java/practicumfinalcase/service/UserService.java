package com.java.practicumfinalcase.service;

import com.java.practicumfinalcase.entity.Admin;
import com.java.practicumfinalcase.payload.response.UserResponse;
import com.java.practicumfinalcase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public UserResponse save(Admin user) {
       userRepository.save(user);
       return UserResponse.builder().
               email(user.getEmail()).
               name(user.getName()).
               surname(user.getSurname()).
               phoneNumber(user.getPhoneNumber()).build();
    }

    public Admin getUserByUserId(Long id){
      Optional<Admin> user = userRepository.findById(id);
      if(user.isPresent()){
          return user.get();
      }
      return user.orElse(null);
    }
    public boolean existsAdminById(Long id){
        return userRepository.existsAdminById(id);
    }
}
