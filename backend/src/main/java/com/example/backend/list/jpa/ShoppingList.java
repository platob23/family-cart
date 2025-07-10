package com.example.backend.list.jpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "shopping_list")
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column
    private Boolean completed;

}
