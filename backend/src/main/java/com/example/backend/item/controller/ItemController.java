package com.example.backend.item.controller;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }
}