package com.ssau.loritimesheets.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ssau.lori.serverapi.ApiConfig;
import com.ssau.lori.serverapi.ServerApi;
import com.ssau.lori.serverapi.entities.AuthResult;
import com.ssau.lori.serverapi.entities.User;

import java.io.IOException;

import lori.ssau.com.myapplication.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_login);
        usernameEditText = (EditText) findViewById(R.id.login_username_text_input_edit_text);
        passwordEditText = (EditText) findViewById(R.id.login_password_text_input_edit_text);
        loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ApiConfig.getEndpoint())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                User user = new User(usernameEditText.getText().toString(), passwordEditText.getText().toString());
                ServerApi serverApi = retrofit.create(ServerApi.class);
                Call<AuthResult> authResult = serverApi.login(user);
                authResult.enqueue(new Callback<AuthResult>() {
                    @Override
                    public void onResponse(Call<AuthResult> call, Response<AuthResult> response) {
                            Log.d(LoginActivity.class.getSimpleName(), response.code() + "");
                    }

                    @Override
                    public void onFailure(Call<AuthResult> call, Throwable t) {
                        Log.e(LoginActivity.class.getSimpleName(), "fail");
                    }
                });

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
