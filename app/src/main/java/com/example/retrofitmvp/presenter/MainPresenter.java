package com.example.retrofitmvp.presenter;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.retrofitmvp.model.Post;
import com.example.retrofitmvp.network.PostRepository;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private PostRepository postRepository = new PostRepository();
    private MutableLiveData<List<Post>> currentPosts = new MutableLiveData<>();
    private MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void getPosts() {

        try {
            postRepository.getPosts().execute();
        } catch (IOException  exception){
            Log.e("ERROR", exception.toString());
        }

        postRepository.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                currentPosts.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                currentPosts = null;
            }
        });

        if(currentPosts != null){
            view.displayPosts(currentPosts);
        } else {
            view.displayError();
        }
    }
}
