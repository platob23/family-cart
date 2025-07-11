package com.example.backend.list.controller;

import com.example.backend.list.dto.ShoppingListDto;
import com.example.backend.list.jpa.ShoppingListRepository;
import com.example.backend.list.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lists")
public class ShoppingListController {

    @Autowired
    private ShoppingListService shoppingListService;


    @GetMapping
    public ResponseEntity<List<ShoppingListDto>> findAllShoppingLists() {
        return ResponseEntity.ok(shoppingListService.getShoppingLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingListDto> findShoppingListById(@PathVariable Long id) {
        Optional<ShoppingListDto> shoppingListDto = shoppingListService.getShoppingListById(id);
        return shoppingListDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/archived")
    public ResponseEntity<List<ShoppingListDto>> findAllArchivedShoppingLists() {
        return ResponseEntity.ok(shoppingListService.getArchivedShoppingLists());
    }

    @GetMapping("/archived/{id}")
    public ResponseEntity<ShoppingListDto> findArchivedShoppingListById(@PathVariable Long id) {

        Optional<ShoppingListDto> shoppingListDto = shoppingListService.getArchivedShoppingListById(id);
        return shoppingListDto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }
}
