package com.example.vk.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author nivanov
 * @since %CURRENT_VERSION%
 */
public record Address(
        @JsonProperty("address") String street,
        @JsonProperty("suite") String suite,
        @JsonProperty("city") String city,
        @JsonProperty("zipcode") String zipcode,
        @JsonProperty("geo") Geo geo
) {
}
