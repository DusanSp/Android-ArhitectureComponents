package com.example.dusan.moviecatalog.model;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dusan on 11.Sep.17.
 */

public class MoviesDataHolder {
  private static MoviesDataHolder sInstance;
  private static List<Movie> mMovieList;

  public static MoviesDataHolder getInstance() {
    if(sInstance == null) {
      sInstance = new MoviesDataHolder();
    }
    return sInstance;
  }

  private MoviesDataHolder() {
    mMovieList = new ArrayList<>();
  }

  public List<Movie> getMovies() {
    return mMovieList;
  }

  public void setMovies(@NonNull List<Movie> movies) {
    mMovieList.addAll(movies);
  }

}
