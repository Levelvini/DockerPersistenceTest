package com.levelVini.DockerPersistenceTest.service;

import com.levelVini.DockerPersistenceTest.exceptions.EmptyListException;
import com.levelVini.DockerPersistenceTest.exceptions.ResourseNotFoundException;
import com.levelVini.DockerPersistenceTest.model.DTOs.OrderRequest;
import com.levelVini.DockerPersistenceTest.model.DTOs.OrderResponse;
import com.levelVini.DockerPersistenceTest.model.Order;
import com.levelVini.DockerPersistenceTest.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
        ModelMapper mapper;
        OrderRepository repository;

    public OrderService(ModelMapper mapper, OrderRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Transactional
    public List<OrderResponse> getAllOrders(){
        List<Order> orders = repository.findAll();
        if (orders.isEmpty()){throw new EmptyListException("no orders finded");
        }
        return orders.stream().map(order-> mapper.map(order,OrderResponse.class)).toList();
    }

    @Transactional
    public Optional<OrderResponse> getById(Long id){
        return Optional.ofNullable(mapper.map(repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Order not founded")), OrderResponse.class));
    }

    @Transactional
    public void save(OrderRequest orderRequest){
        repository.save(mapper.map(orderRequest,Order.class));
    }

    @Transactional
    public String update(Long id, OrderRequest orderRequest){
        Order order = repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("order not founded"));
        Order orderUpdated = repository.save(order = mapper.map(orderRequest,Order.class));
        return "order " + orderUpdated.getId() + " has been updated";
    }

    @Transactional
    public void delete(Long id){
        repository.delete(repository.findById(id).orElseThrow(()-> new ResourseNotFoundException("the order has not founded")));
    }
}
