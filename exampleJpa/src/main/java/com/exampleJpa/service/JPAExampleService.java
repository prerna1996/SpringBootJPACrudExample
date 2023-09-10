package com.exampleJpa.service;

import com.exampleJpa.UserEntity;

import java.util.List;


public interface JPAExampleService {
     UserEntity saveUserData(UserEntity userEntity);
     List<UserEntity> getUserData();
     UserEntity updateUserData(UserEntity userEntity);
     void deleteUserData(Long id);
}
