package com.leo.retrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.leo.retrofitdemo.R;
import com.leo.retrofitdemo.api.App;
import com.leo.retrofitdemo.bean.CookListBean;
import com.leo.retrofitdemo.ui.adapter.CookListAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class CookListActivity extends AppCompatActivity {

    @BindView(R.id.cook_recycler)
    RecyclerView mCookRecycler;
    private CookListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cook_list);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mAdapter = new CookListAdapter(this);
        App
                .initCookList(1,20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<CookListBean, List<CookListBean.TngouBean>>() {
                    @Override
                    public List<CookListBean.TngouBean> call(CookListBean cookListBean) {
                        return cookListBean.getTngou();
                    }
                }).subscribe(new Action1<List<CookListBean.TngouBean>>() {
            @Override
            public void call(List<CookListBean.TngouBean> list) {
                mAdapter.addAll(list);
                mCookRecycler.setLayoutManager(new
                        LinearLayoutManager(CookListActivity.this,LinearLayoutManager.VERTICAL,false));
                mCookRecycler.setAdapter(mAdapter);
            }
        });
    }
}
