package com.example.backend.controller;
import com.example.backend.model.ItemEntity;
import com.example.backend.model.ListEntity;
import com.example.backend.service.FamilyCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class FamilyCartController {

    @Autowired
    private FamilyCartService familyCartService;

    @GetMapping
    public List<ListEntity> getAllLists() {
        return familyCartService.getAllLists();
    }

    @GetMapping("blabla")
    public List<ItemEntity> getAllItems() {
        return familyCartService.getItemsAll();
    }

    @GetMapping("/{id}")
    public ListEntity getListById(@PathVariable Long id) {
        return familyCartService.getListById(id);
    }
}
