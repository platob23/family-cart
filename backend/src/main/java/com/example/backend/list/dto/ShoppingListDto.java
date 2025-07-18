package com.example.backend.list.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "quantity", "createdAt", "createdBy", "completed"})
public class ShoppingListDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty("created_at")
    private Timestamp createdAt;
    @JsonProperty("created_by")
    private String createdBy;
    @JsonProperty
    private Boolean completed;

}
