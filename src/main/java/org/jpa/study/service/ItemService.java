package org.jpa.study.service;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.ItemEntity;
import org.jpa.study.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public void saveItems(ItemEntity itemEntity) {
        itemRepository.save(itemEntity);
    }

    public List<ItemEntity> findItemsAll() {
        return itemRepository.findAll();
    }

    public ItemEntity findItemsOne(Long itemId) {
        // TODO orElseThrow 로 Exception 만들기
        return itemRepository.findById(itemId).orElse(null);
    }


}
