package com.levelVini.DockerPersistenceTest.model.DTOs;

import com.levelVini.DockerPersistenceTest.model.Order;
import com.levelVini.DockerPersistenceTest.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserResponse {
    Long id;
    String name;
    String email;
    List<Long> ordersId;

    public UserResponse(Long id, String name, String email, List<Long> ordersId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ordersId = ordersId;
    }

    public UserResponse toUserResponse(User user){
        UserResponse userResponse = new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getOrders().stream().map(Order::getId).collect(Collectors.toList())
        );
        return userResponse;
    }
}
