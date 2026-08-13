package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

  public UserResponse create(CreateUserRequest dto) {
    UserModel user = new UserModel(dto);
    this.userRepository.save(user);
    return UserResponse.from(user);
  }

  public List<UserResponse> getAll() {
    return this.userRepository.findAll()
        .stream()
        .map(UserResponse::from)
        .toList();
  }

  public Optional<UserResponse> getById(UUID userId) {
    return this.userRepository.findById(userId)
        .map(UserResponse::from);
  }

}
