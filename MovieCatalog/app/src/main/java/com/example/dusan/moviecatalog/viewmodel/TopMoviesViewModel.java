package com.example.dusan.moviecatalog.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import com.example.dusan.moviecatalog.repository.TopMoviesRepository;

/**
 * Created by Dusan on 20.Aug.17.
 */

public class TopMoviesViewModel extends ViewModel{

  private MediatorLiveData<MoviesResponse> mData;
  private TopMoviesRepository mRepository;

  public TopMoviesViewModel() {
    mRepository = new TopMoviesRepository();
    mData = new MediatorLiveData<>();

    loadData(1);
  }

  public LiveData<MoviesResponse> getData() {
    return mData;
  }

  public void loadData(int page) {
    mData.addSource(mRepository.getMovies(page), new Observer<MoviesResponse>() {
      @Override
      public void onChanged(@Nullable MoviesResponse movieList) {
        mData.postValue(movieList);
      }
    });
  }
}
