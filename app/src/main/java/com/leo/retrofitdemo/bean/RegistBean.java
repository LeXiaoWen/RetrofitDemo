package com.leo.retrofitdemo.bean;

/**
 * Created by Leo on 2017/3/8.
 */

public class RegistBean {


    /**
     * access_token : 2257de6214191652094152f0d82867f6
     * refresh_token : 98789362l402b2ce829b9ae8ce9e826f79c9da465c5bae66043ecf49
     * id : 3
     * status : true
     */

    private String access_token;
    private String refresh_token;
    private int id;
    private boolean status;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
