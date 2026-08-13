package com.tweteroo.api.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.request.CreateUserRequest;
import com.tweteroo.api.dtos.response.UserResponse;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

  final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public UserResponse create(@RequestBody @Valid CreateUserRequest body) {
    return this.userService.create(body);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserResponse> getById(@PathVariable UUID userId) {
    return this.userService.getById(userId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

}
