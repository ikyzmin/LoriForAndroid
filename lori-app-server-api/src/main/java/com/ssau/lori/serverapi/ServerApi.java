package com.ssau.lori.serverapi;


import com.ssau.lori.serverapi.entities.AuthResult;
import com.ssau.lori.serverapi.entities.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServerApi {

    @POST("login")
    Call<AuthResult> login(@Body User user);
}
