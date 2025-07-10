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

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.ItemToItemDto(items);
    }

    public Optional<ItemDto> findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(itemMapper::ItemToItemDto);
    }
}
