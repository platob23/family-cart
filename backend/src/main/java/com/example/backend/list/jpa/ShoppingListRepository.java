package com.example.backend.list.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static javax.swing.text.html.HTML.Tag.SELECT;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

    List<ShoppingList> findAllByCompletedIsTrue();

    @Query("SELECT s FROM ShoppingList s WHERE s.completed = :completed AND s.id = :id")
    Optional<ShoppingList> findShoppingListByCompletedAndId(@Param("completed")Boolean completed, @Param("id") Long id);

    Optional<ShoppingList> findShoppingListById(Long id);
}
