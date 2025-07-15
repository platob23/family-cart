package com.example.backend.item.jpa;

import com.example.backend.list.jpa.ShoppingList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "item", schema = "public")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer quantity;

    @Column
    private Boolean checked;

    @Column(name = "added_by")
    private String addedBy;

    @Column(name = "list_id")
    private Long listId;
}
