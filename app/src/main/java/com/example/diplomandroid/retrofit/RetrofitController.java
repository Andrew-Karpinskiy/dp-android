package com.example.diplomandroid.retrofit;

import android.content.Context;
import android.widget.Toast;

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
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
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
                System.out.println(response.body().getResponse());
                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Toast.makeText(context, "LOX!!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void sendRegistrationRequest(Context context, String email, String password) {
//        Call<ApiResponse> c = client.registration(email, password);
//        c.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                Toast.makeText(context, response.body().getResponse(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Toast.makeText(context, "LOX", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    public void login(Context context,String email, String password) {
//        Call c = client.login(email, password);
//        c.enqueue(new Callback() {
//
//           @Override
//            public void onResponse(Call call, Response response) {
//               Toast.makeText(context, "Correct!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                    Toast.makeText(context, "lox!!!!!!!!!!", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    //Отправка запроса к Api
//    public void getData(Context context, TextView textView) {
//        Call<ApiResponse> c = client.test();
//        c.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                textView.setText(response.body().getResponse());
//            }
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Toast.makeText(context, "Lox", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    //Отправка запроса к Api
//    public void sendData(Context context,TextView textView) {
//        Call<ApiResponse> c = client.send("Andrew","Karpinskiy");
//        c.enqueue(new Callback<ApiResponse>() {
//            @Override
//            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
//                textView.setText(response.body().getResponse());
//            }
//
//            @Override
//            public void onFailure(Call<ApiResponse> call, Throwable t) {
//                Toast.makeText(context, "Lox", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}
