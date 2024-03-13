package com.example.vk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record Album(
        @JsonProperty("userId") Long userId,
        @JsonProperty("id") Long id,
        @JsonProperty("title") String title
) {
}
