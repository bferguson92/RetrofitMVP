package com.example.retrofitmvp.network;

import com.example.retrofitmvp.model.Post;

import java.util.List;

import retrofit2.Call;

public class PostRepository {
    private PostService postService = new PostService();

    public Call<List<Post>> getPosts(){
        return postService.getPostApi().getPosts();
    }
}
