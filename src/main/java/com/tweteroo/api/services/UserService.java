package com.tweteroo.api.services;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.request.CreateUserRequest;
import com.tweteroo.api.dtos.response.UserResponse;
import com.tweteroo.api.models.UserModel;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

  final UserRepository userRepository;

  UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public UserResponse save(CreateUserRequest dto) {
    UserModel user = new UserModel(dto);
    this.userRepository.save(user);
    return UserResponse.from(user);
  }
}
