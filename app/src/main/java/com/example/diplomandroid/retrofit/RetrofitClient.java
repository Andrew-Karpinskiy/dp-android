package com.example.diplomandroid.retrofit;

import com.example.diplomandroid.retrofit.data.request.AuthRequest;
import com.example.diplomandroid.retrofit.data.request.CalculatorsRequest;
import com.example.diplomandroid.retrofit.data.request.RegistrationRequest;
import com.example.diplomandroid.retrofit.data.response.AuthResponse;
import com.example.diplomandroid.retrofit.data.response.CalculatorsResponse;
import com.example.diplomandroid.retrofit.data.response.SimpleResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitClient {

    @POST("register")
    Call<SimpleResponse> registration(@Body RegistrationRequest registrationRequest);

    @POST("auth")
    Call<AuthResponse> authentication(@Body AuthRequest authRequest);

    @POST("/calculators/bmi")
    Call<CalculatorsResponse> bmiIndex(@Body CalculatorsRequest calculatorsRequest);

    @POST("/calculators/dwr")
    Call<CalculatorsResponse> dwr(@Body CalculatorsRequest calculatorsRequest);

    @POST("/calculators/iw")
    Call<CalculatorsResponse> idealWeight(@Body CalculatorsRequest calculatorsRequest);

    @POST("/calculators/dcm")
    Call<CalculatorsResponse> dailyCalories(@Body CalculatorsRequest calculatorsRequest);

//    @Headers("Content-Type:application/json; charset=UTF-8")
//    @GET("/user/get")
//    Call<ApiResponse> testAuth(@Header("Authorization") String auth);
//
//    @GET("/user/get")
//    Call<ApiResponse> testNoAuth();
}