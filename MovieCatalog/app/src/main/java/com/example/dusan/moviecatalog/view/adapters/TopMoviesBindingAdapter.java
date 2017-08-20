package com.example.dusan.moviecatalog.view.adapters;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import com.example.dusan.moviecatalog.model.MoviesResponse;
import java.util.List;

/**
 * Created by Dusan on 20.Aug.17.
 */

public final class TopMoviesBindingAdapter {

  @BindingAdapter(value = "adapter")
  public static void setData(RecyclerView recyclerView, MoviesResponse moviesResponse) {
    RecyclerView.Adapter adapter = recyclerView.getAdapter();

    if (adapter == null) {
      return;
    }

    if (moviesResponse == null || moviesResponse.getResults() == null) {
      return;
    }

    if (adapter instanceof BaseAdapter) {
      ((BaseAdapter) adapter).setData((List) moviesResponse.getResults());
    }
  }
}
