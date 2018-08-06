package com.hai.bt9.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hai.bt9.R;
import com.hai.bt9.api.Api;
import com.hai.bt9.custom.adapter.PostAdapter;
import com.hai.bt9.interfaces.ItemOnClick;
import com.hai.bt9.model.Post;
import com.hai.bt9.util.Config;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity implements ItemOnClick {
    RecyclerView rcvPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    void initView() {
        rcvPost = findViewById(R.id.rcv_post);
        rcvPost.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    void bindingData(List<Post> pots) {
        rcvPost.setAdapter(new PostAdapter(pots, this));
    }

    public void getData(View v) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        api.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                bindingData(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            }
        });
    }

    @Override
    public void onClick(Object o) {
        if (o instanceof Post) {
            Intent t = new Intent(this, DetailActivity.class);
            t.putExtra(DetailActivity.POST, (Post) o);
            startActivity(t);
        }
    }
}
