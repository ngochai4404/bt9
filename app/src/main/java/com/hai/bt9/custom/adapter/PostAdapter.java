package com.hai.bt9.custom.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hai.bt9.R;
import com.hai.bt9.interfaces.ItemOnClick;
import com.hai.bt9.model.Post;

import java.util.List;

/**
 * Created by Hai on 06/08/2018.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    final String USER_ID = "UserId: ";
    final String TITLE = "Title: ";
    List<Post> posts;
    ItemOnClick itemOnClick;

    public PostAdapter(List<Post> posts, ItemOnClick itemOnClick) {
        this.posts = posts;
        this.itemOnClick = itemOnClick;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position) {
        final Post post = posts.get(position);
        holder.tvTitle.setText(USER_ID + post.getUserId());
        holder.tvConent.setText(TITLE + post.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemOnClick.onClick(post);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvConent;

        public PostHolder(View itemView) {
            super(itemView);
            tvConent = itemView.findViewById(R.id.tv_conent);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
