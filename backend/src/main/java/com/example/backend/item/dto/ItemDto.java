package com.example.backend.item.dto;

import com.example.backend.list.jpa.ShoppingList;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "quantity", "checked", "addedBy", "listId"})
public class ItemDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Integer quantity;
    @JsonProperty
    private Boolean checked;
    @JsonProperty
    private String addedBy;
    @JsonProperty
    private Long listId;
}
