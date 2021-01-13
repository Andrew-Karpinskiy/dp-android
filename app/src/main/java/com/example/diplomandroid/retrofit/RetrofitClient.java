package com.example.diplomandroid.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitClient {

    @POST("register")
    Call<ApiResponse> registration(@Body RegistrationRequest registrationRequest);

    @POST("auth")
    Call<ApiResponse> authentication(@Body AuthRequest authRequest);

}