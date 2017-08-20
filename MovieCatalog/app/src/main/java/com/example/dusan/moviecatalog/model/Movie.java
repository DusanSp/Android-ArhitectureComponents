package com.example.dusan.moviecatalog.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Dusan on 25.Jul.17.
 */

public class Movie {

  @SerializedName("id")
  @Setter
  @Getter
  private int id;
  @SerializedName("release_date")
  @Setter
  @Getter
  private String relaseDate;
  @SerializedName("original_title")
  @Setter
  @Getter
  private String originalTitle;
  @SerializedName("title")
  @Setter
  @Getter
  private String title;
  @SerializedName("vote_average")
  @Setter
  @Getter
  private double averageRating;
  @SerializedName("poster_path")
  @Setter
  @Getter
  private String posterPath;
  @SerializedName("overview")
  @Setter
  @Getter
  private String overview;
  @SerializedName("vote_count")
  @Setter
  @Getter
  private double voteCount;
  @SerializedName("original_language")
  @Setter
  @Getter
  private String originalLanguage;
}
