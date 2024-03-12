package com.example.vk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public record PostComment (
        @JsonProperty("postId") Long postId,
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("email") String email,
        @JsonProperty("body") String body
) {
}
