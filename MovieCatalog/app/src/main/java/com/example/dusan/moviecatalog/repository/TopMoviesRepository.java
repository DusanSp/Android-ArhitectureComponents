package com.example.dusan.moviecatalog.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import com.example.dusan.moviecatalog.model.api.ApiConstants;
import com.example.dusan.moviecatalog.model.api.ApiManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dusan on 27.Jul.17.
 */

public class TopMoviesRepository {

  public LiveData<MoviesResponse> getMovies(int page) {
    final MutableLiveData<MoviesResponse> movies = new MutableLiveData<>();

    ApiManager.Api().getTopRatedMovies(ApiConstants.API_KEY, page).enqueue(
        new Callback<MoviesResponse>() {
          @Override
          public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
            if(response.body() != null) {
              movies.setValue((response.body()));
            }
          }

          @Override
          public void onFailure(Call<MoviesResponse> call, Throwable t) {
            movies.setValue(null);
          }
        });

    return movies;
  }

}
