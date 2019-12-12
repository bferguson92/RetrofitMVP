package com.example.retrofitmvp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvp.R;
import com.example.retrofitmvp.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts = new ArrayList<>();

    public void updatePosts(List<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String userIdText = Integer.toString(posts.get(position).getUserId());
        String idText = Integer.toString(posts.get(position).getId());

        holder.userId.setText(userIdText);
        holder.id.setText(idText);
        holder.body.setText(posts.get(position).getBody());
        holder.title.setText(posts.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView userId;
        TextView id;
        TextView body;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.user_id_display);
            id = itemView.findViewById(R.id.id_display);
            body = itemView.findViewById(R.id.body_display);
            title = itemView.findViewById(R.id.title_display);
        }
    }
}
