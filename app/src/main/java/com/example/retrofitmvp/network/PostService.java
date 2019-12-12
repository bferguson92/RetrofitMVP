package com.example.retrofitmvp.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostService {
    private PostApi postApi;

    public PostService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postApi = retrofit.create(PostApi.class);
    }

    public PostApi getPostApi() {
        return postApi;
    }
}
