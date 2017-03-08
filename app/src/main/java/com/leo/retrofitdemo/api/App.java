package com.leo.retrofitdemo.api;

import com.google.gson.Gson;
import com.leo.retrofitdemo.bean.CookListBean;
import com.leo.retrofitdemo.bean.HotEventsBean;
import com.leo.retrofitdemo.bean.LoginBean;
import com.leo.retrofitdemo.bean.RegistBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Leo on 2017/3/7.
 */

public class App {
    public static Retrofit initRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiContancts.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


        return retrofit;
    }

    public static Observable<CookListBean> initCookList(int page,int rows){
        Observable<CookListBean> cookList = initRetrofit()
                .create(ApiService.class)
                .getCookList(page, rows);
        return cookList;
    }
    public static Observable<HotEventsBean> initHotEvents(int page, int rows){
        Observable<HotEventsBean> hotEvents = initRetrofit()
                .create(ApiService.class)
                .getHotEvents(page, rows);
        return hotEvents;
    }

    public static Observable<RegistBean> initRegist(String email
            ,String account
            ,String password){

        Observable<RegistBean> regist = initRetrofit()
                .create(ApiService.class)
                .myRegist(ApiContancts.CLIENT_ID
                        , ApiContancts.CLIENT_SECRET
                        , email, account, password);

        return regist;
    }


    public static Observable<LoginBean> initLogin(String userName,String passWord){
        Observable<LoginBean> login = initRetrofit()
                .create(ApiService.class)
                .myLogin(ApiContancts.CLIENT_ID
                        , ApiContancts.CLIENT_SECRET
                        , userName
                        , passWord);
        return login;
    }




}
