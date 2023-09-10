package com.exampleJpa.service;

import com.exampleJpa.UserEntity;
import com.exampleJpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAExampleServiceImpl implements JPAExampleService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity saveUserData(UserEntity userEntity) {
     return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getUserData() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity updateUserData(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUserData(Long id) {
         userRepository.deleteById(id);
    }
}
