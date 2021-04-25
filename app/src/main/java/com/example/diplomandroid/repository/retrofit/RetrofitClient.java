package com.example.diplomandroid.repository.retrofit;

import com.example.diplomandroid.repository.retrofit.request.AuthRequest;
import com.example.diplomandroid.repository.retrofit.request.CalculatorsRequest;
import com.example.diplomandroid.repository.retrofit.request.JournalSaveRequest;
import com.example.diplomandroid.repository.retrofit.request.RegistrationRequest;
import com.example.diplomandroid.repository.retrofit.response.AuthResponse;
import com.example.diplomandroid.repository.retrofit.response.CalculatorsResponse;
import com.example.diplomandroid.repository.retrofit.response.JournalResponse;
import com.example.diplomandroid.repository.retrofit.response.SimpleResponse;

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

    @POST("/journals/steps")
    Call<JournalResponse> saveSteps(@Body JournalSaveRequest journalSaveRequest);

    @POST("/journals/calories")
    Call<JournalResponse> saveCalories(@Body JournalSaveRequest journalSaveRequest);

    @POST("/journals/distance")
    Call<JournalResponse> saveDistance(@Body JournalSaveRequest journalSaveRequest);

    @POST("/journals/weight")
    Call<JournalResponse> saveWeight(@Body JournalSaveRequest journalSaveRequest);


//    @Headers("Content-Type:application/json; charset=UTF-8")
//    @GET("/user/get")
//    Call<ApiResponse> testAuth(@Header("Authorization") String auth);
//
//    @GET("/user/get")
//    Call<ApiResponse> testNoAuth();
}