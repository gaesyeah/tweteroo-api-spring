package com.tweteroo.api.controllers;

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

  @PostMapping()
  public UserResponse createUser(@RequestBody @Valid CreateUserRequest body) {
    return this.userService.save(body);
  }

}
