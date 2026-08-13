package com.tweteroo.api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tweteroo.api.dtos.request.CreateTweetRequest;
import com.tweteroo.api.dtos.response.TweetResponse;
import com.tweteroo.api.models.TweetModel;
import com.tweteroo.api.repositories.TweetRepository;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class TweetService {

  final TweetRepository tweetRepository;
  final UserRepository userRepository;

  TweetService(TweetRepository tweetRepository, UserRepository userRepository) {
    this.tweetRepository = tweetRepository;
    this.userRepository = userRepository;
  }

  public Optional<TweetResponse> create(CreateTweetRequest body) {
    return this.userRepository
        .findById(body.userId())
        .map(user -> {
          TweetModel tweet = new TweetModel(body.text(), user);
          this.tweetRepository.save(tweet);
          return TweetResponse.from(tweet);
        });
  }

  public List<TweetResponse> getAll() {
    return this.tweetRepository
        .findAll()
        .stream()
        .map(TweetResponse::from)
        .toList();
  }

  public List<TweetResponse> getAllByUserId(UUID userId) {
    // Vai retornar um array vazio se o usuário não existir.
    // Buscar o usuário antes é desnecessário e não performático.
    return this.tweetRepository
        .findAllByUserId(userId)
        .stream()
        .map(TweetResponse::from)
        .toList();
  }
}
