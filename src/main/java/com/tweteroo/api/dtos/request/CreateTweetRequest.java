package com.tweteroo.api.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTweetRequest(
    @NotBlank String text,
    @NotNull Long userId) {
}