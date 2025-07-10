package com.example.backend.list.dto;

import com.example.backend.item.dto.ItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "quantity", "createdAt", "createdBy", "completed"})
public class ListDto {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Timestamp createdAt;
    @JsonProperty
    private String createdBy;
    @JsonProperty
    private Boolean completed;

}
