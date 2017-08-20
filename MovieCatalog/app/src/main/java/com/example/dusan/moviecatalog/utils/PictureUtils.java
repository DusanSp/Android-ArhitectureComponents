package com.example.dusan.moviecatalog.utils;

import android.widget.ImageView;
import com.example.dusan.moviecatalog.view.application.MovieCatalogApplication;
import com.squareup.picasso.Picasso;

/**
 * Created by Dusan on 01.Aug.17.
 */

public class PictureUtils {

  public static void loadImageInTo(final String url, ImageView imageView) {
    Picasso.with(MovieCatalogApplication.getInstance())
        .load("https://image.tmdb.org/t/p/w92" + url)
        .into(imageView);
  }

  public static void loadImageLargeInTo(final String url, ImageView imageView) {
    Picasso.with(MovieCatalogApplication.getInstance())
        .load("https://image.tmdb.org/t/p/w300" + url)
        .into(imageView);
  }
}
