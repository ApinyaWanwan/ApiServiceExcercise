package com.example.apinya.apiexcercise;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private ApiService service;
    private HttpManager(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/blogger/v3/blogs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public ApiService getService() {
        return service;
    }
}
