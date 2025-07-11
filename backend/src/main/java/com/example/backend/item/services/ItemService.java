package com.example.backend.item.services;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.dto.ItemMapper;
import com.example.backend.item.jpa.Item;
import com.example.backend.item.jpa.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.itemsToItemDto(items);
    }

    public Optional<ItemDto> findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(itemMapper::itemToItemDto);
    }

    public List<ItemDto> findByListId(Long listId) {
        List<Item> items = itemRepository.findItemsByShoppingListId(listId);
        return itemMapper.itemsToItemDto(items);
    }
}
