package com.example.vk.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public record Geo (
        @JsonProperty("lat") Double lat,
        @JsonProperty("lng") Double lng
){
}
