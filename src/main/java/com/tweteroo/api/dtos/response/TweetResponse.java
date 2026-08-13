package com.tweteroo.api.dtos.response;

import java.util.UUID;

public record TweetResponse(String text, UUID userId, UserResponse user) {
}
