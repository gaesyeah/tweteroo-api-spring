package com.tweteroo.api.dtos.request;

import jakarta.validation.constraints.Size;

public record PatchTweetRequest(
        @Size(min = 1) String title,
        @Size(min = 1) String text) {
}
