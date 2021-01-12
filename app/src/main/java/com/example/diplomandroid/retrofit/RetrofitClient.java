package com.example.diplomandroid.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitClient {

    //    @GET("exchange?json")
//    Call<List<ApiResponse>> getPostWithID();
//
//    @GET("/test")
//    Call<ApiResponse> test();
//
    @POST("/registration/{em}/{pa}")
    Call<ApiResponse> registration(@Path("em") String email, @Path("pa") String password);
}