package com.example.retrofitmvp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvp.R;
import com.example.retrofitmvp.adapter.PostAdapter;
import com.example.retrofitmvp.model.Post;
import com.example.retrofitmvp.presenter.MainContract;
import com.example.retrofitmvp.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainPresenter presenter = new MainPresenter(this);
    private PostAdapter postAdapter = new PostAdapter();
    private TextView error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.posts_display);
        recyclerView.setAdapter(postAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        error = findViewById(R.id.error_display);

        presenter.getPosts();
    }

    @Override
    public void displayPosts(LiveData<List<Post>> posts) {
        posts.observe(this, new Observer<List<Post>>() {

            @Override
            public void onChanged(List<Post> posts) {
                postAdapter.updatePosts(posts);
            }
        });


    }

    @Override
    public void displayError() {
        error.setVisibility(View.VISIBLE);
    }
}
