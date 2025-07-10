package com.example.backend.item.dto;

import com.example.backend.item.jpa.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ItemMapper {
    ItemDto ItemToItemDto(Item item);
    List<ItemDto> ItemToItemDto(List<Item> items);
}
