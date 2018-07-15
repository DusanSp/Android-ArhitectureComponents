package com.example.dusan.moviecatalog.view.activities;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.model.MoviesDataHolder;
import com.example.dusan.moviecatalog.view.fragments.MovieDetailFragment;

/**
 * Created by Dusan on 22.Aug.17.
 */

public class DetailMovieActivity extends LifecycleActivity {

  private static final String EXTRA_MOVIE_ID = "movie_id";

  public static Intent newIntent(Context packageContext, int movieId) {
    Intent intent = new Intent(packageContext, DetailMovieActivity.class);
    intent.putExtra(EXTRA_MOVIE_ID, movieId);
    return intent;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_movie);

    initViewPager();
  }

  private void initViewPager() {
    ViewPager mViewPager = (ViewPager) findViewById(R.id.view_pager);
    mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
      @Override
      public Fragment getItem(int position) {
        Movie movie = MoviesDataHolder.getInstance().getMovies().get(position);

        return MovieDetailFragment.newInstance(movie.getId());
      }

      @Override
      public int getCount() {
        return MoviesDataHolder.getInstance().getMovies().size();
      }
    });

    for (int i = 0; i < MoviesDataHolder.getInstance().getMovies().size(); i++) {
      if (MoviesDataHolder.getInstance().getMovies().get(i).getId() == getIntent()
          .getIntExtra(EXTRA_MOVIE_ID, -1)) {
        mViewPager.setCurrentItem(i);
        break;
      }
    }
  }

}
