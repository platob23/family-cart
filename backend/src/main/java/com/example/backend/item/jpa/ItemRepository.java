package com.example.backend.item.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findItemsByShoppingListId(Long listId);
}
