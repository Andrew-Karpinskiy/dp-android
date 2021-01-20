package com.example.diplomandroid.retrofit;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.diplomandroid.LoginActivity;
import com.example.diplomandroid.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitController {

    private static final String BASE_URL = "http://10.0.2.2:8080/";
    private final RetrofitClient client;

    public RetrofitController() {
        client = buildRetrofit().create(RetrofitClient.class);
    }


    //Настройка Retrofit
    private Retrofit buildRetrofit() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void registration(Context context, String email, String password) {
        RegistrationRequest registrationRequest = new RegistrationRequest(email, password);
        Call<ApiResponse> c = client.registration(registrationRequest);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getResponse().equals("Email exist")) {
                        Toast.makeText(context, "Email exist", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(Context context, String email, String password) {
        AuthRequest authRequest = new AuthRequest(email, password);
        Call<ApiResponse> c = client.authentication(authRequest);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    String result = response.body().getResponse();
                    if (result.equals("Invalid email")) {
                        Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show();
                    } else if (result.equals("Invalid password")) {
                        Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show();
                    } else {
                        Token.setToken(response.body().getResponse());
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getBodyMassIndex(Context context, double weight, double height) {
        Call<ApiResponse> c = client.bmiIndex(weight, height);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDailyWaterRequirement(Context context, double weight) {
        Call<ApiResponse> c = client.dwr(weight);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getIdealWeight(Context context, String sex, double height) {
        Call<ApiResponse> c = client.idealWeight(sex, height);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getDailyCaloriesAmount(Context context, String sex, double weight, double height, double age,
                                       int load) {
        Call<ApiResponse> c = client.dailyCalories(sex, weight, height, age, load);
        c.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

//    public void testAuth(Context context) {
//        Call<ApiResponse> c = client.testAuth(Token.getToken());
//        c.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void testNoAuth(Context context) {
//        Call<ApiResponse> c = client.testNoAuth();
//        c.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}

