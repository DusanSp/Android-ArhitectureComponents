package com.example.dusan.moviecatalog.view.fragments;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.databinding.FragmentTopMoviesBinding;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import com.example.dusan.moviecatalog.view.activities.DetailMovieActivity;
import com.example.dusan.moviecatalog.view.adapters.TopMoviesAdapter;
import com.example.dusan.moviecatalog.viewmodel.TopMoviesViewModel;

/**
 * Created by Dusan on 20.Aug.17.
 */

public class TopMoviesListFragment extends LifecycleFragment implements TopMoviesAdapter.OnItemClick{

  private FragmentTopMoviesBinding mBinding;

  public static TopMoviesListFragment newInstance() {
    return new TopMoviesListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_top_movies, container, false);
    mBinding = DataBindingUtil.bind(view.getRootView());
    return view.getRootView();
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mBinding.recyclerMovies.setLayoutManager(new LinearLayoutManager(getContext()));
    TopMoviesAdapter topMoviesAdapter = new TopMoviesAdapter();
    topMoviesAdapter.setListener(this);
    mBinding.recyclerMovies.setAdapter(topMoviesAdapter);
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    initViewModel();
  }

  private void initViewModel() {
    TopMoviesViewModel viewModel = ViewModelProviders.of(this).get(TopMoviesViewModel.class);
    viewModel.getData().observe(TopMoviesListFragment.this, new Observer<MoviesResponse>() {
      @Override
      public void onChanged(@Nullable MoviesResponse moviesResponse) {
        mBinding.setData(moviesResponse);
      }
    });
  }

  @Override
  public void onDestroyView() {
    mBinding.unbind();
    super.onDestroyView();
  }

  @Override
  public void onItemClick(int id) {
    Intent intent = DetailMovieActivity.newIntent(getActivity(), id);
    startActivity(intent);
  }
}
