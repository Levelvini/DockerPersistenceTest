package com.levelVini.DockerPersistenceTest.model.DTOs;

import com.levelVini.DockerPersistenceTest.model.enums.OrderStatus;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private String description;
    private LocalDate date;
    @NotBlank(message = "Order status missing")
    private OrderStatus orderStatus;
    private Long userId;
}
