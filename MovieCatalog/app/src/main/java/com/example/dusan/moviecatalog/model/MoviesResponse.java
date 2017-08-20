package com.example.dusan.moviecatalog.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Dusan on 25.Jul.17.
 */

public class MoviesResponse {
  @SerializedName("page")
  @Setter
  @Getter
  private int page;
  @SerializedName("results")
  @Setter
  @Getter
  private List<Movie> results;
  @SerializedName("total_results")
  @Setter
  @Getter
  private int totalResults;
  @SerializedName("total_pages")
  @Setter
  @Getter
  private int totalPages;
}
