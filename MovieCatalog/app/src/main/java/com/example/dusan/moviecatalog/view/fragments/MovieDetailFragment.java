package com.example.dusan.moviecatalog.view.fragments;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.databinding.FragmentMovieDetailBinding;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.utils.PictureUtils;
import com.example.dusan.moviecatalog.viewmodel.MovieDetailViewModel;

/**
 * Created by Dusan on 07.Aug.17.
 */

public class MovieDetailFragment extends LifecycleFragment {
  public static final String MOVIE_ID = "movie_id";

  private MovieDetailViewModel mViewModel;
  private FragmentMovieDetailBinding mBinding;

  public static MovieDetailFragment newInstance(int id) {
    MovieDetailFragment fragment = new MovieDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putInt(MOVIE_ID, id);
    fragment.setArguments(bundle);
    return fragment;
  }

  public FragmentMovieDetailBinding getBinding() {
    return mBinding;
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
    mBinding = DataBindingUtil.bind(view);
    return view;
  }

  @Override
  public void onDestroyView() {
    mBinding.unbind();
    super.onDestroyView();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    Bundle bundle = getArguments();
    if(bundle != null){
      mViewModel = new MovieDetailViewModel();

      mViewModel.loadMovie(bundle.getInt(MOVIE_ID));

      mViewModel.getMovie().observe(MovieDetailFragment.this, new Observer<Movie>() {
        @Override
        public void onChanged(@Nullable Movie movie) {
          if(movie != null) {
            getBinding().textTitle.setText(movie.getTitle());
            getBinding().textOriginalTitle.setText(movie.getOriginalTitle());
            getBinding().textYear.setText(movie.getRelaseDate());
            getBinding().textOverview.setText(movie.getOverview());
            PictureUtils.loadImageLargeInTo(movie.getPosterPath(), getBinding().imageDetailPoster);
          }
        }
      });
    }
  }
}
