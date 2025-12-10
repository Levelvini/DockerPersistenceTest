package com.levelVini.DockerPersistenceTest.service;

import com.levelVini.DockerPersistenceTest.exceptions.EmptyListException;
import com.levelVini.DockerPersistenceTest.exceptions.ResourseNotFoundException;
import com.levelVini.DockerPersistenceTest.model.DTOs.UserRequest;
import com.levelVini.DockerPersistenceTest.model.DTOs.UserResponse;
import com.levelVini.DockerPersistenceTest.model.User;
import com.levelVini.DockerPersistenceTest.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository repository;
    ModelMapper mapper;

    public UserService(UserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    //Test using ModelMapper to parse all entities into a list
    @Transactional
    public List<UserResponse> getAllUsers(){
        List<UserResponse> users = repository.findAll().stream().map(UserResponse::toUserResponse).toList();
        if (users.isEmpty()){
            throw new EmptyListException("theres no user inserted!");
        }
        return users;
    }

    @Transactional
    public Optional<UserResponse> getById(Long id){
    return Optional.of(UserResponse.toUserResponse(repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("User not founded!"))));
    }

    @Transactional
    public String save(UserRequest user){
        repository.save(mapper.map(user,User.class));
        return "user " + user.getName() + "!";
    }

    @Transactional
    public String update(Long id, UserRequest user){
        User userUpdate = repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("entity not founded"));
        User userReturn = repository.save(userUpdate = mapper.map(user,User.class));
        return userReturn.getName() + " has been updated!";
    }

    @Transactional
    public String delete(Long id){
        repository.delete(repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("user not exist")));
        return "user has been deleted";
    }
}
