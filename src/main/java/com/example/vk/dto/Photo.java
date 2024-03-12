package com.example.vk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public record Photo (
        @JsonProperty("albumId") Long albumId,
        @JsonProperty("id") Long id,
        @JsonProperty("title") String title,
        @JsonProperty("url") String url,
        @JsonProperty("thumbnailUrl") String thumbnailUrl
){
}
