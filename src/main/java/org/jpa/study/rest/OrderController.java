package org.jpa.study.rest;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.OrderEntity;
import org.jpa.study.entity.OrderItemEntity;
import org.jpa.study.entity.enums.OrderStatus;
import org.jpa.study.entity.zipcode.Address;
import org.jpa.study.service.ItemService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final ItemService itemService;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @PostMapping(value = "api/v1/cart")
    public void addToCart() {

        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setCount(1);

        entityManager.persist(orderItemEntity);

        entityManager.flush();
        entityManager.close();

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderStatus(OrderStatus.장바구니);
        orderEntity.setAddress(new Address("51-0","seoul","street"));

        entityManager.persist(orderEntity);
    }

}
