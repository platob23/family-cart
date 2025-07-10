package com.example.backend.list.dto;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.jpa.Item;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ListMapper {
    ListDto listToListDto(List<Item> items);
    ItemDto itemToItemDto(Item item);
}
