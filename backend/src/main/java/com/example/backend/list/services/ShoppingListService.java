package com.example.backend.list.services;

import com.example.backend.list.dto.ShoppingListDto;
import com.example.backend.list.dto.ShoppingListMapper;
import com.example.backend.list.jpa.ShoppingList;
import com.example.backend.list.jpa.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final ShoppingListMapper shoppingListMapper;

    public ShoppingListService(ShoppingListRepository shoppingListRepository, ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    public List<ShoppingListDto> getShoppingLists() {
        List<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        return shoppingListMapper.shoppingListsToListDtos(shoppingLists);
    }


    public Optional<ShoppingListDto> getShoppingListById(Long id) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        return shoppingList.map(shoppingListMapper::shoppingListToListDto);
    }

    public List<ShoppingListDto> getArchivedShoppingLists() {
        List<ShoppingList> shoppingListsArchived = shoppingListRepository.findAllByCompletedIsTrue();
        return shoppingListMapper.shoppingListsToListDtos(shoppingListsArchived);
    }

    public Optional<ShoppingListDto> getArchivedShoppingListById(Long iddd) {
        Optional<ShoppingList> shoppingList = shoppingListRepository.findShoppingListByCompletedAndId(true, iddd);
        return shoppingList.map(shoppingListMapper::shoppingListToListDto);
    }
}
