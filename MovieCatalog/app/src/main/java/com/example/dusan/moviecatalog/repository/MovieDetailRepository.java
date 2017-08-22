package com.example.dusan.moviecatalog.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.model.api.ApiConstants;
import com.example.dusan.moviecatalog.model.api.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dusan on 07.Aug.17.
 */

public class MovieDetailRepository {

  public LiveData<Movie> getMovie(int movieId) {
    final MutableLiveData<Movie> movie = new MutableLiveData<>();
    ApiManager.Api().getMovie(movieId, ApiConstants.API_KEY).enqueue(new Callback<Movie>() {
      @Override
      public void onResponse(Call<Movie> call, Response<Movie> response) {
        if(response.body() != null) {
          movie.setValue(response.body());
        }
      }

      @Override
      public void onFailure(Call<Movie> call, Throwable t) {

      }
    });
    return movie;
  }
}
