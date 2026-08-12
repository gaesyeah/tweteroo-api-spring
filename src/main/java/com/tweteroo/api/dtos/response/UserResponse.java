package com.tweteroo.api.dtos.response;

import com.tweteroo.api.models.UserModel;

public record UserResponse(Long id, String avatar, String username) {

  public static UserResponse from(UserModel user) {
    return new UserResponse(user.getId(), user.getAvatar(), user.getUsername());
  }
}
