package com.example.apinya.apiexcercise;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("byurl")
    Call<Collection> repos(@Query("url") String url, @Query("key") String key);
}
