package com.exampleJpa;

import com.exampleJpa.service.JPAExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JPAExampleController {
    @Autowired
    JPAExampleService jpaExampleService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello";
    }


    @PostMapping(value = "/user")
    public ResponseEntity saveUserData(@RequestBody UserEntity userEntity){
        try {
            jpaExampleService.saveUserData(userEntity);
           return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
           return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserEntity>> getUserData(){
        try {
            return new ResponseEntity<>(jpaExampleService.getUserData(),HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping(value = "/user")
    public ResponseEntity updateUserData(@RequestBody UserEntity userEntity){
        try {
            jpaExampleService.updateUserData(userEntity);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity updateUserData(@RequestParam(value = "userId") Long userId){
        try {
            jpaExampleService.deleteUserData(userId);
            return new ResponseEntity<>(HttpStatusCode.valueOf(200));
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }
    }
}
