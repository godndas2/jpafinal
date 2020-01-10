package org.jpa.study.service;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.*;
import org.jpa.study.entity.ItemEntity;
import org.jpa.study.exception.UserNotFoundException;
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

        UserEntity userEntity = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        ItemEntity itemEntity = itemService.findItemsOne(itemId);

//        DeliveryEntity deliveryEntity = new DeliveryEntity(Objects.requireNonNull(userEntity).getCity());
        OrderItemEntity orderItemEntity = OrderItemEntity.createOrderItems(itemEntity, itemEntity.getPrice(), count);
//        OrderEntity orderEntity = OrderEntity.createOrders(userEntity, deliveryEntity, orderItemEntity);

//        orderRepository.save(orderEntity);
//        return orderEntity.getId();
        return null;


    }
}
