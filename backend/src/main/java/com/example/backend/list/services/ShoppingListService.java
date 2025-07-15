package com.example.backend.list.services;

import com.example.backend.list.dto.ShoppingListDto;
import com.example.backend.list.dto.ShoppingListMapper;
import com.example.backend.list.jpa.ShoppingList;
import com.example.backend.list.jpa.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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


    public ShoppingListDto createShoppingList(ShoppingListDto shoppingListDto) {
        ShoppingList shoppingList = shoppingListMapper.listDtoToShoppingList(shoppingListDto);
        shoppingList.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ShoppingList saved = shoppingListRepository.save(shoppingList);
        return shoppingListMapper.shoppingListToListDto(saved);
    }

    public boolean deleteShoppingListById(Long id) {
        if (shoppingListRepository.existsById(id)) {
            shoppingListRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public boolean markeAsCompletedByID(Long id) {
        Optional<ShoppingList> shoppingListCompleted = shoppingListRepository.findShoppingListById(id);
        if (shoppingListCompleted.isPresent()) {
            shoppingListCompleted.get().setCompleted(true);
            shoppingListRepository.save(shoppingListCompleted.get());
            return true;
        }
        return false;
    }

    public Optional<ShoppingListDto> patchShoppingListById(Long id, ShoppingListDto update) {

        Optional<ShoppingList> shoppingList = shoppingListRepository.findById(id);
        if (!shoppingList.isPresent()) {
            return Optional.empty();
        }

        if(update.getName() != null) {
            shoppingList.get().setName(update.getName());
        }
        if(update.getCompleted() != null) {
            shoppingList.get().setCompleted(update.getCompleted());
        }

        shoppingListRepository.save(shoppingList.get());


        return Optional.of(shoppingListMapper.shoppingListToListDto(shoppingList.get()));
    }
}
