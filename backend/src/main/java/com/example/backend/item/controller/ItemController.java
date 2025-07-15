package com.example.backend.item.controller;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping
    public ResponseEntity<List<ItemDto>> findAllItems() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable Long id) {
        Optional<ItemDto> itemDto = itemService.findById(id);
        return itemDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("inList/{listId}")
    public ResponseEntity<List<ItemDto>> findItemsByListId(@PathVariable Long listId) {
        return ResponseEntity.ok(itemService.findByListId(listId));
    }

    @PostMapping
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto newItem = itemService.createItem(itemDto);
        return ResponseEntity.ok(newItem);
    }

}