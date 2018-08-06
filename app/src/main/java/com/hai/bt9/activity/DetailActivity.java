package com.hai.bt9.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hai.bt9.R;
import com.hai.bt9.model.Post;

public class DetailActivity extends AppCompatActivity {
    public static final String POST = "POST";
    TextView tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        bindingData();
    }

    void initView() {
        tvBody = findViewById(R.id.tv_body);
    }

    void bindingData() {
        Post post = getIntent().getParcelableExtra(POST);
        if (post != null) {
            tvBody.setText(post.getBody());
        }
    }
}
