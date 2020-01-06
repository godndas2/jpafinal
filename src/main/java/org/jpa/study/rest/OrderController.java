package org.jpa.study.rest;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.OrderEntity;
import org.jpa.study.entity.OrderItemEntity;
import org.jpa.study.entity.enums.OrderStatus;
import org.jpa.study.repository.OrderRepository;
import org.jpa.study.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "api/v1/cart")
    public void addToCart() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderStatus(OrderStatus.주문완료);

        entityManager.persist(orderEntity);

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setOrderPrice(5000);
        orderItemEntity.setCount(1);

        // TODO OrderItemEntity PK +1 증가됨
        entityManager.persist(orderItemEntity);

        entityManager.close();
    }
}
