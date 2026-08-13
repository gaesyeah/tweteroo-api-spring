package com.tweteroo.api.dtos.request;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTweetRequest(
    @NotBlank String title,
    @NotBlank String text,
    @NotNull UUID userId) {
}