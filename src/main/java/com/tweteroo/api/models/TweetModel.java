package com.tweteroo.api.models;

import java.util.UUID;

import com.tweteroo.api.dtos.request.CreateTweetRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "tweets")
public class TweetModel {

  public TweetModel(CreateTweetRequest dto, UserModel user) {
    this.title = dto.title();
    this.text = dto.text();
    this.user = user;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Setter
  @Column(nullable = false)
  private String title;

  @Setter
  @Column(nullable = false)
  private String text;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserModel user;
}
