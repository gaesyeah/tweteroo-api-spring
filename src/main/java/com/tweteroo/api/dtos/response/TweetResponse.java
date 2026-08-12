package com.tweteroo.api.dtos.response;

public record TweetResponse(
    String text,
    Long userId,
    UserResponse user) {
}
