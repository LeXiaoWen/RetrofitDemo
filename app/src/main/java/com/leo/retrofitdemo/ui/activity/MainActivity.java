package com.leo.retrofitdemo.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.leo.retrofitdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.hot)
    Button mHot;
    @BindView(R.id.cook)
    Button mCook;
    @BindView(R.id.beauty)
    Button mBeauty;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.hot, R.id.cook, R.id.beauty})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hot:
                startActivity(new Intent(this,HotEventsActivity.class));
                break;
            case R.id.cook:
                startActivity(new Intent(this,CookListActivity.class));
                break;
            case R.id.beauty:
                startActivity(new Intent(this,BeautyImageActivity.class));
                break;
        }
    }
}
