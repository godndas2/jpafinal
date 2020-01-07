package org.jpa.study.service;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.*;
import org.jpa.study.repository.OrderRepository;
import org.jpa.study.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    private final ItemService itemService;

    // Order
    public Long getOrder(Long userId,
                         Long itemId,
                         int count) {

        // TODO orElseThrow 로 Exception 만들기
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        ItemEntity itemEntity = itemService.findItemsOne(itemId);

        DeliveryEntity deliveryEntity = new DeliveryEntity(Objects.requireNonNull(userEntity).getCity());
        System.out.println("");
        OrderItemEntity orderItemEntity = OrderItemEntity.createOrderItems(itemEntity, itemEntity.getPrice(), count);
        OrderEntity orderEntity = OrderEntity.createOrders(userEntity, deliveryEntity, orderItemEntity);

        orderRepository.save(orderEntity);
        return orderEntity.getId();


    }
}
