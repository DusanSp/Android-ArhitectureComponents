package com.example.dusan.moviecatalog.viewmodel;

import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.repository.MovieDetailRepository;

/**
 * Created by Dusan on 07.Aug.17.
 */

public class MovieDetailViewModel extends ViewModel {

  private MediatorLiveData<Movie> mMovie;
  private MovieDetailRepository mMovieDetailRepository;

  public MovieDetailViewModel() {
    mMovieDetailRepository = new MovieDetailRepository();
    mMovie = new MediatorLiveData<>();
  }

  public MediatorLiveData<Movie> getMovie() {
    return mMovie;
  }

  public void loadMovie(int movieId) {
    mMovie.addSource(mMovieDetailRepository.getMovie(movieId), new Observer<Movie>() {
      @Override
      public void onChanged(@Nullable Movie movie) {
        if(movie != null){
          mMovie.setValue(movie);
        }
      }
    });
  }
}
