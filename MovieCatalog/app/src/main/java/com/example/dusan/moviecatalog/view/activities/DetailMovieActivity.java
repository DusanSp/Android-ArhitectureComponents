package com.example.dusan.moviecatalog.view.activities;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import com.example.dusan.moviecatalog.view.fragments.MovieDetailFragment;
import com.example.dusan.moviecatalog.viewmodel.TopMoviesViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dusan on 22.Aug.17.
 */

public class DetailMovieActivity extends LifecycleActivity {

  private static final String EXTRA_MOVIE_ID = "movie_id";
  private List<Movie> mMovieList = new ArrayList<>();
  private ViewPager mViewPager;
  private int movieId;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_movie);

    mViewPager = (ViewPager) findViewById(R.id.view_pager);

    initViewModel();

    movieId = getIntent().getIntExtra(EXTRA_MOVIE_ID, -1);
  }

  private void initViewModel() {
    TopMoviesViewModel viewModel = ViewModelProviders.of(this).get(TopMoviesViewModel.class);
    viewModel.getData().observe(DetailMovieActivity.this, new Observer<MoviesResponse>() {
      @Override
      public void onChanged(@Nullable MoviesResponse moviesResponse) {
        if (moviesResponse != null && moviesResponse.getResults() != null) {
          mMovieList = moviesResponse.getResults();

          mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
              Movie movie = mMovieList.get(position);

              return MovieDetailFragment.newInstance(movie.getId());
            }

            @Override
            public int getCount() {
              return mMovieList.size();
            }
          });

          for (int i = 0; i < mMovieList.size(); i++) {
            if (mMovieList.get(i).getId() == movieId) {
              mViewPager.setCurrentItem(i);
              break;
            }
          }
        }
      }
    });
  }

  public static Intent newIntent(Context packageContext, int movieId) {
    Intent intent = new Intent(packageContext, DetailMovieActivity.class);
    intent.putExtra(EXTRA_MOVIE_ID, movieId);
    return intent;
  }
}
