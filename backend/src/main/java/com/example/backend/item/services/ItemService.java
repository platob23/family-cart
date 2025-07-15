package com.example.backend.item.services;

import com.example.backend.item.dto.ItemDto;
import com.example.backend.item.dto.ItemMapper;
import com.example.backend.item.jpa.Item;
import com.example.backend.item.jpa.ItemRepository;
import com.example.backend.list.jpa.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    private ShoppingListRepository shoppingListRepository;

    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper,  ShoppingListRepository shoppingListRepository) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
        this.shoppingListRepository = shoppingListRepository;
    }

    public List<ItemDto> findAll() {
        List<Item> items = itemRepository.findAll();
        return itemMapper.itemsToItemDto(items);
    }

    public Optional<ItemDto> findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(itemMapper::itemToItemDto);
    }

    public List<ItemDto> findByListId(Long listId) {
        List<Item> items = itemRepository.findItemsByListId(listId);
        return itemMapper.itemsToItemDto(items);
    }

    public ItemDto createItem(ItemDto itemDto) {
        // Prüfen ob die ShoppingList existiert
        if (itemDto.getListId() != null && !shoppingListRepository.existsById(itemDto.getListId())) {
            throw new RuntimeException("Shopping List with ID " + itemDto.getListId() + " not found");
        }

        Item item = itemMapper.itemDtoToItem(itemDto);
        Item savedItem = itemRepository.save(item);
        return itemMapper.itemToItemDto(savedItem);
    }

    public boolean deleteItem(Long id) {
        if(itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ItemDto patchItem(Long id, ItemDto updatedItem) {
        Item itemWithId = itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item with ID " + id + " not found"));

        if(updatedItem.getName() != null && !itemWithId.getName().equals(updatedItem.getName())) {
            itemWithId.setName(updatedItem.getName());
        }
        if(updatedItem.getQuantity() != null && !itemWithId.getQuantity().equals(updatedItem.getQuantity())) {
            itemWithId.setQuantity(updatedItem.getQuantity());
        }
        if(updatedItem.getListId() != null && !itemWithId.getListId().equals(updatedItem.getListId())) {
            itemWithId.setListId(updatedItem.getListId());
        }
        return itemMapper.itemToItemDto(itemRepository.save(itemWithId));
    }
}
