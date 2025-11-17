package com.levelVini.DockerPersistenceTest.controller;

import com.levelVini.DockerPersistenceTest.model.DTOs.UserRequest;
import com.levelVini.DockerPersistenceTest.model.DTOs.UserResponse;
import com.levelVini.DockerPersistenceTest.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers(){
    return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<UserResponse>> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> update(@PathVariable Long id,@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.update(id,request));
    }

    @PostMapping
    public ResponseEntity<String> save(@Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(service.save(request));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
}
