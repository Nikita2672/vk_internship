package com.example.vk.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public record User(
        @JsonProperty("id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("username") String username,
        @JsonProperty("email") String email,
        @JsonProperty("address") Address address,
        @JsonProperty("phone") String phone,
        @JsonProperty("website") String website,
        @JsonProperty("company") Company company

) {
}
