package com.leo.retrofitdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leo.retrofitdemo.R;
import com.leo.retrofitdemo.api.App;
import com.leo.retrofitdemo.bean.LoginBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.user_name)
    EditText mUserName;
    @BindView(R.id.pass_word)
    EditText mPassWord;
    @BindView(R.id.login)
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login)
    public void onClick() {
        String userName = mUserName.getText().toString();
        String passWord = mPassWord.getText().toString();

        login(userName,passWord);
    }

    private void login(String userName, String passWord) {
        App
                .initLogin(userName,passWord)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<LoginBean>() {
                    @Override
                    public void call(LoginBean loginBean) {
                        if (loginBean.isStatus()){
                            Toast.makeText(LoginActivity.this, "登录成功！"
                                    , Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }
                    }
                });
    }
}
