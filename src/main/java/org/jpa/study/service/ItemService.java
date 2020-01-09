package org.jpa.study.service;

import lombok.RequiredArgsConstructor;
import org.jpa.study.entity.items.ItemEntity;
import org.jpa.study.exception.ItemNotFoundException;
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

        return itemRepository.findById(itemId).orElseThrow(ItemNotFoundException::new);
    }


}
