package com.leo.retrofitdemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leo.retrofitdemo.R;
import com.leo.retrofitdemo.api.App;
import com.leo.retrofitdemo.bean.RegistBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RegistActivity extends AppCompatActivity {

    @BindView(R.id.email)
    EditText mEmail;
    @BindView(R.id.account)
    EditText mAccount;
    @BindView(R.id.pass_word)
    EditText mPassWord;
    @BindView(R.id.regist)
    Button mRegist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.regist)
    public void onClick() {
        String email = mEmail.getText().toString();
        String account = mAccount.getText().toString();
        String password = mPassWord.getText().toString();
        regist(email,account,password);
    }

    private void regist(String email, String account, String password) {
        Observable<RegistBean> regist = App.initRegist(email, account, password);
        regist
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<RegistBean>() {
                    @Override
                    public void call(RegistBean registBean) {
                        if(registBean.isStatus()){
                            Toast.makeText(RegistActivity.this
                                    , "注册成功！", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistActivity.this,LoginActivity.class));
                            finish();
                        }else {
                            Toast.makeText(RegistActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
