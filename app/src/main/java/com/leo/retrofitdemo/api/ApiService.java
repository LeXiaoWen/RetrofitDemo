package com.leo.retrofitdemo.api;

import com.leo.retrofitdemo.bean.CookListBean;
import com.leo.retrofitdemo.bean.HotEventsBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Leo on 2017/3/7.
 */

public interface ApiService {
    @GET("/api/top/list")
    Observable<HotEventsBean> getHotEvents(@Query("page") int page, @Query("rows") int rows);

    @GET("/api/cook/list")
    Observable<CookListBean> getCookList(@Query("page") int page, @Query("rows") int rows);
}
