package com.levelVini.DockerPersistenceTest.model.DTOs;

import com.levelVini.DockerPersistenceTest.model.User;
import com.levelVini.DockerPersistenceTest.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderResponse {
    Long id;
    String description;
    LocalDateTime date;
    OrderStatus status;
    Long clienteId;

}
