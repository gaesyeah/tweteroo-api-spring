package com.tweteroo.api.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
    @NotBlank String avatar,
    @NotBlank String username) {
}
