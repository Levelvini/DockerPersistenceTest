package com.levelVini.DockerPersistenceTest.model;

import com.levelVini.DockerPersistenceTest.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime date;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    private User client;
}
