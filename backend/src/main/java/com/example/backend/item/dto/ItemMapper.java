package com.example.backend.item.dto;

import com.example.backend.item.jpa.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    ItemDto itemToItemDto(Item item);
    List<ItemDto> itemsToItemDto(List<Item> items);
    Item itemDtoToItem(ItemDto itemDto);
}
