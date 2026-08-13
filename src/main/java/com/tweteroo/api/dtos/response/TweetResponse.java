package com.tweteroo.api.dtos.response;

import java.util.UUID;

import com.tweteroo.api.models.TweetModel;

public record TweetResponse(UUID id, String title, String text, UserResponse user) {

  public static TweetResponse from(TweetModel tweet) {
    return new TweetResponse(tweet.getId(), tweet.getTitle(), tweet.getText(), UserResponse.from(tweet.getUser()));
  }

}
