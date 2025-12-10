package com.levelVini.DockerPersistenceTest.controller;

import com.levelVini.DockerPersistenceTest.model.DTOs.OrderRequest;
import com.levelVini.DockerPersistenceTest.model.DTOs.OrderResponse;
import com.levelVini.DockerPersistenceTest.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> gelAll(){
        return ResponseEntity.ok(service.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrderResponse>> getById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @Valid @RequestBody OrderRequest request){
        return ResponseEntity.ok(service.update(id,request));
    }

    @PostMapping
    public ResponseEntity<String> post(@Valid @RequestBody OrderRequest orderRequest){
        service.save(orderRequest);
        return ResponseEntity.ok("the order as been post");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("the order as been deleted");
    }
}
