package com.levelVini.DockerPersistenceTest.model.DTOs;

import com.levelVini.DockerPersistenceTest.model.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "insert a valid name!")
    @Size(min = 3,message = "very short name")
    private String name;
    @NotBlank(message = "email missing")
    private String email;

    List<Order> orders;
}
