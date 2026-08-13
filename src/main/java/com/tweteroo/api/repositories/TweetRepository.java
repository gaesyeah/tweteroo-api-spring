package com.tweteroo.api.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.models.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, UUID> {
  List<TweetModel> findAllByUserId(UUID userId);
}
