package com.example.backend.list.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

}
