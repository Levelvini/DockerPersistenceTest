package com.levelVini.DockerPersistenceTest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    private String name;

    @JoinColumn
    private String email;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Order> orders;

}
