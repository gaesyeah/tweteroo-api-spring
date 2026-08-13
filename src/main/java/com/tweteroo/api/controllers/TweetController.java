package com.tweteroo.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dtos.request.CreateTweetRequest;
import com.tweteroo.api.dtos.request.PatchTweetRequest;
import com.tweteroo.api.dtos.response.TweetResponse;
import com.tweteroo.api.services.TweetService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("tweets")
public class TweetController {

  final TweetService tweetService;

  public TweetController(TweetService tweetService) {
    this.tweetService = tweetService;
  }

  @PostMapping
  public Optional<TweetResponse> create(@RequestBody @Valid CreateTweetRequest body) {
    return this.tweetService.create(body);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<TweetResponse> patch(@PathVariable UUID id, @RequestBody @Valid PatchTweetRequest body) {
    return this.tweetService.patch(id, body)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<TweetResponse> getAll() {
    return this.tweetService.getAll();
  }

  @GetMapping("/{userId}")
  public List<TweetResponse> getAllByUserId(@PathVariable UUID userId) {
    return this.tweetService.getAllByUserId(userId);
  }

}
