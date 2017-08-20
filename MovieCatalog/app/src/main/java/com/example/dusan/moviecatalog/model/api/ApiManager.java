package com.example.dusan.moviecatalog.model.api;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dusan on 25.Jul.17.
 */

public class ApiManager {

  private static ApiMethods mApiMethods;

  public static ApiMethods Api() {
    if (mApiMethods == null) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
              Request original = chain.request();

              Request request = original.newBuilder()
                  .header("X-Via", "Android")
                  .header("Accept", "application/json")
                  .method(original.method(), original.body())
                  .build();

              return chain.proceed(request);
            }
          })
          .addInterceptor(interceptor)
          .build();

      Retrofit retrofit = new Retrofit.Builder()
          .baseUrl(ApiConstants.BASE_URL)
          .client(client)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
      mApiMethods = retrofit.create(ApiMethods.class);
    }
    return mApiMethods;
  }
}
