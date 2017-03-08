package com.leo.retrofitdemo.api;

import com.leo.retrofitdemo.bean.CookListBean;
import com.leo.retrofitdemo.bean.HotEventsBean;
import com.leo.retrofitdemo.bean.LoginBean;
import com.leo.retrofitdemo.bean.RegistBean;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Leo on 2017/3/7.
 */

public interface ApiService {
    @GET("/api/top/list")
    Observable<HotEventsBean> getHotEvents(
            @Query("page") int page, @Query("rows") int rows);

    @GET("/api/cook/list")
    Observable<CookListBean> getCookList(@Query("page") int page, @Query("rows") int rows);


    @FormUrlEncoded
    @POST("/api/oauth2/reg")
    Observable<RegistBean> myRegist(@Field("client_id") String client_id
            ,@Field("client_secret") String client_secret
            ,@Field("email") String email
            ,@Field("account") String account
            ,@Field("password") String password);

    @FormUrlEncoded
    @POST("/api/oauth2/login")
    Observable<LoginBean> myLogin(@Field("client_id") String client_id
            ,@Field("client_secret") String client_secret
            ,@Field("name") String name
            ,@Field("password") String password  );

}
