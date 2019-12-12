package com.example.retrofitmvp.network;

import com.example.retrofitmvp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {
    @GET("posts")
    Call<List<Post>> getPosts();
}
