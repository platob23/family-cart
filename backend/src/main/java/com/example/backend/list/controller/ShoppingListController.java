package com.example.backend.list.controller;

import com.example.backend.list.dto.ShoppingListDto;
import com.example.backend.list.jpa.ShoppingList;
import com.example.backend.list.jpa.ShoppingListRepository;
import com.example.backend.list.services.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    // Post neue Liste
   @PostMapping
    public ResponseEntity<ShoppingListDto> createShoppingList(@RequestBody ShoppingListDto shoppingListDto) {
        ShoppingListDto created = shoppingListService.createShoppingList(shoppingListDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
   }

    //Liste by id löschen
   @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteShoppingListById(@PathVariable Long id) {
        boolean deleted = shoppingListService.deleteShoppingListById(id);
        return deleted ? ResponseEntity.ok("Item deleted successfully. ID: " + id)
                : ResponseEntity.ok("Item not deleted successfully. ID: " + id);
   }

   @PatchMapping("/{id}/complete")
    public ResponseEntity<String> markedShoppingListAsCompletedById(@PathVariable Long id) {
        boolean markedShoppingListAsCompleted = shoppingListService.markeAsCompletedByID(id);
        return markedShoppingListAsCompleted ? ResponseEntity.ok("Item marked successfully. ID: " + id)
                : ResponseEntity.ok("Item marked failed");
   }

   @PatchMapping("/{id}")
    public ResponseEntity<ShoppingListDto> patchShoppingListById(@PathVariable Long id,  @RequestBody ShoppingListDto shoppingListDto) {
        Optional<ShoppingListDto> shoppingListDto1 = shoppingListService.patchShoppingListById(id, shoppingListDto);
        return shoppingListDto1.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

}
