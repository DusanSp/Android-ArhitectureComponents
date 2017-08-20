package com.example.dusan.moviecatalog.view.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.view.fragments.TopMoviesListFragment;

public class TopMoviesActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_top_movies);

    getSupportFragmentManager().beginTransaction()
        .add(R.id.fragment_holder, TopMoviesListFragment.newInstance())
        .commit();
  }
}
