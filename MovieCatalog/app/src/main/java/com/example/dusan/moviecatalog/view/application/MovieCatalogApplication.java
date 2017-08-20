package com.example.dusan.moviecatalog.view.application;

import android.app.Application;

/**
 * Created by Dusan on 01.Aug.17.
 */

public class MovieCatalogApplication extends Application {

  private static MovieCatalogApplication instance;

  public static MovieCatalogApplication getInstance() {
    return instance;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    instance = this;
  }
}
