package com.example.dusan.moviecatalog.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dusan.moviecatalog.R;
import com.example.dusan.moviecatalog.model.Movie;
import com.example.dusan.moviecatalog.model.MoviesDataHolder;
import com.example.dusan.moviecatalog.utils.PictureUtils;
import com.example.dusan.moviecatalog.view.adapters.TopMoviesAdapter.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dusan on 27.Jul.17.
 */

public class TopMoviesAdapter extends BaseAdapter<ViewHolder, Movie> {

  private OnItemClick listener;

  public void setListener(OnItemClick listener) {
    this.listener = listener;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.row_movie, parent, false));
  }

  @Override
  public void onBindViewHolder(final ViewHolder holder, int position) {
    final Movie movie = MoviesDataHolder.getInstance().getMovies().get(position);

    holder.mTitle.setText(movie.getTitle());
    holder.mRating.setText(String.valueOf(movie.getAverageRating()));
    PictureUtils.loadImageInTo(movie.getPosterPath(), holder.mPoster);

    holder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (listener != null) {
          listener.onItemClick(movie.getId());
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return MoviesDataHolder.getInstance().getMovies().size();
  }

  @Override
  public void setData(List<Movie> data) {
    if(data != null) {
      MoviesDataHolder.getInstance().setMovies(data);
      notifyDataSetChanged();
    }
  }

  public interface OnItemClick {

    void onItemClick(int id);
  }

  class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTitle;
    private TextView mRating;
    private ImageView mPoster;

    ViewHolder(View itemView) {
      super(itemView);

      mTitle = (TextView) itemView.findViewById(R.id.text_title);
      mRating = (TextView) itemView.findViewById(R.id.text_rating);
      mPoster = (ImageView) itemView.findViewById(R.id.image_poster);
    }
  }

}


