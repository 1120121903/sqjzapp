package com.sys8.sqjzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.sys8.sqjzapp.utils.StatusBarUtils.setWindowStatusBarColor;

/**
 * date:2020/3/27
 * author:wy
 * description:用户登录
 */
public class LoginActivity extends AppCompatActivity {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.et_login_password)
    EditText etLoginPassword;
    @BindView(R.id.bt_login_login)
    Button btLoginLogin;
    @BindView(R.id.bt_login_clear)
    Button btLoginClear;
    @BindView(R.id.tv_login_state)
    TextView tvLoginState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        setWindowStatusBarColor(this, R.color.blue1);
        deviceVerify();
    }

    private void deviceVerify() {

        JSONObject jsons = new JSONObject();
        try {
            jsons.put("name", "山东");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        postRequest(jsons.toString(), new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //服务器返回的内容
                String responseData = response.body().string();
                /**JSON数据处理示例**/
                try {
                    if (!new JSONObject(responseData).has("data")) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvLoginState.setText("网络验证失败");
                            }
                        });
                    } else {
                        JSONObject jsonObject = new JSONObject(responseData).getJSONObject("data");
                        String state = jsonObject.getString("state");
                        if (state.equals("true")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    btLoginLogin.setClickable(true);
                                    btLoginLogin.setEnabled(true);
                                }
                            });
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tvLoginState.setText("网络验证失败");
                                    btLoginLogin.setClickable(false);
                                    btLoginLogin.setEnabled(false);
                                }
                            });
                        }
                    }
//
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //异常情况的处理
            }
        });
    }


    public void postRequest(String json, Callback callback) {
        String address = "https://www.fastmock.site/mock/852f5c4fdacc5fa613d3a7cbb6fbaea5/sqjzAppTest/getUsingState";
        RequestBody body = RequestBody.create(json, JSON);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).post(body).build();
        client.newCall(request).enqueue(callback);
    }

    @OnClick(R.id.bt_login_login)
    public void login(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        finish();
    }

}
