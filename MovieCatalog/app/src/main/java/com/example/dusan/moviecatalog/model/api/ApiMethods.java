package com.example.dusan.moviecatalog.model.api;

import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Dusan on 25.Jul.17.
 */

public interface ApiMethods {

  @GET("movie/top_rated")
  Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey,
      @Query("page") int pageNumber);

  @GET("movie/{id}")
  Call<Movie> getMovie(@Path("id") int id, @Query("api_key") String apiKey);
}
