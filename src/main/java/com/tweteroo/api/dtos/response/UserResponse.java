package com.tweteroo.api.dtos.response;

import java.util.UUID;

import com.tweteroo.api.models.UserModel;

public record UserResponse(UUID id, String avatar, String username) {

  public static UserResponse from(UserModel user) {
    return new UserResponse(user.getId(), user.getAvatar(), user.getUsername());
  }
}
