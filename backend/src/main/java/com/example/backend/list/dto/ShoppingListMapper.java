package com.example.backend.list.dto;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.dto.ItemMapper;
import com.example.backend.item.jpa.Item;
import com.example.backend.list.jpa.ShoppingList;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = ItemMapper.class)
public interface ShoppingListMapper {
    ShoppingListDto shoppingListToListDto(ShoppingList shoppingList);
    List<ShoppingListDto> shoppingListsToListDtos(List<ShoppingList> shoppingLists);
    ShoppingList listDtoToShoppingList(ShoppingListDto listDto);
}