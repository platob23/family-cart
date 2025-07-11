package com.example.backend.item.controller;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.jpa.Item;
import com.example.backend.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ItemDto>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findById(@PathVariable Long id) {
        Optional<ItemDto> itemDto = itemService.findById(id);
        return itemDto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("list/{listId}")
    public ResponseEntity<List<ItemDto>> findByListId(@PathVariable Long listId) {
        return ResponseEntity.ok(itemService.findByListId(listId));
    }

}