package com.sys8.sqjzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.sys8.sqjzapp.utils.StatusBarUtils.setWindowStatusBarColor;

/**
 * date:2020/3/27
 * author:wy
 * description:用户登录
 */
public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.bt_login_clear)
    Button btLoginClear;
    @BindView(R.id.bt_login_login)
    Button btLoginLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setWindowStatusBarColor(this, R.color.blue1);
    }

    @OnClick(R.id.bt_login_login)
    public void login(View v) {
        Intent intent = new Intent(this,MainActivity.class);
        this.startActivity(intent);
        finish();
    }

    @OnClick(R.id.bt_login_clear)
    public void clear(View v) {
        etLoginName.setText("");
        etLoginPassword.setText("");
    }
}
