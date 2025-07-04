package com.example.backend.service;

import com.example.backend.model.ItemEntity;
import com.example.backend.model.ListEntity;
import com.example.backend.repository.ItemRepository;
import com.example.backend.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyCartService {

    @Autowired
    private ListRepository listRepository;
    @Autowired
    private ItemRepository itemRepository;

    public List<ListEntity> getAllLists() {
        return listRepository.findAll();
    }

    public ListEntity getListById(Long id) {
        return listRepository.findById(id).orElse(null);
    }

    public List<ItemEntity> getItemsAll () {
        return itemRepository.findAll();
    }
}
