package com.example.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity = 1;

    private Boolean checked = false;

    @Column(name = "added_by")
    private String addedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private ListEntity shoppingList;
}
