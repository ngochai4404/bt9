package com.hai.bt9.api;

import com.hai.bt9.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hai on 06/08/2018.
 */

public interface Api {
    @GET("/posts")
    Call<List<Post>> getPosts();
}
