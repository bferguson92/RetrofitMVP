package com.example.retrofitmvp.presenter;

import androidx.lifecycle.LiveData;

import com.example.retrofitmvp.model.Post;

import java.util.List;

public interface MainContract {

    interface Presenter{
        void getPosts();
    }

    interface View {
        void displayPosts(LiveData<List<Post>> posts);
        void displayError();
    }
}
