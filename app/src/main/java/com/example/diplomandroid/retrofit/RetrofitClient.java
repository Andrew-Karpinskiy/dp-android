package com.example.diplomandroid.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitClient {

    @POST("register")
    Call<ApiResponse> registration(@Body RegistrationRequest registrationRequest);

    @POST("auth")
    Call<ApiResponse> authentication(@Body AuthRequest authRequest);

    @GET("/calculators/bmi/{weight}/{height}")
    Call<ApiResponse> bmiIndex(@Path("weight") double weight, @Path("height") double height);

    @GET("/calculators/dwr/{weight}")
    Call<ApiResponse> dwr(@Path("weight") double weight);

//    @Headers("Content-Type:application/json; charset=UTF-8")
//    @GET("/user/get")
//    Call<ApiResponse> testAuth(@Header("Authorization") String auth);
//
//    @GET("/user/get")
//    Call<ApiResponse> testNoAuth();
}