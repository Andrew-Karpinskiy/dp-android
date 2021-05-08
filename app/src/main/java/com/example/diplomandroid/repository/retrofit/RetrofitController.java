package com.example.diplomandroid.repository.retrofit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.diplomandroid.R;
import com.example.diplomandroid.activity.LoginActivity;
import com.example.diplomandroid.repository.retrofit.request.AuthRequest;
import com.example.diplomandroid.repository.retrofit.request.CalculatorsRequest;
import com.example.diplomandroid.repository.retrofit.request.JournalSaveRequest;
import com.example.diplomandroid.repository.retrofit.request.RegistrationRequest;
import com.example.diplomandroid.repository.retrofit.response.AuthResponse;
import com.example.diplomandroid.repository.retrofit.response.CalculatorsResponse;
import com.example.diplomandroid.repository.retrofit.response.JournalResponse;
import com.example.diplomandroid.repository.retrofit.response.SimpleResponse;
import com.example.diplomandroid.ui.journals.calories.CaloriesJournalActivity;
import com.example.diplomandroid.ui.journals.distance.DistanceJournalActivity;
import com.example.diplomandroid.ui.journals.steps.StepsJournalActivity;
import com.example.diplomandroid.ui.journals.weight.WeightJournalActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

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

    private Retrofit buildRetrofit() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public void registration(Context context, String email, String password) {
        RegistrationRequest registrationRequest = new RegistrationRequest(email, password);
        Call<SimpleResponse> c = client.registration(registrationRequest);
        c.enqueue(new Callback<SimpleResponse>() {
            @Override
            public void onResponse(Call<SimpleResponse> call, Response<SimpleResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getMessage().equals("Email exist")) {
                        Toast.makeText(context, "Email exist", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(context, LoginActivity.class);
                        context.startActivity(intent);
                    }
                }

            }
            @Override
            public void onFailure(Call<SimpleResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void login(Context context, String email, String password) {
        AuthRequest authRequest = new AuthRequest(email, password);
        Call<AuthResponse> c = client.authentication(authRequest);
        c.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.isSuccessful()) {
                    String result = response.body().getMessage();
                    if (result.equals("Invalid email")) {
                        Toast.makeText(context, "Invalid email", Toast.LENGTH_SHORT).show();
                    } else if (result.equals("Invalid password")) {
                        Toast.makeText(context, "Invalid password", Toast.LENGTH_SHORT).show();
                    } else {
                        Token.setToken(response.body().getToken());
//                        Intent intent = new Intent(context, MainActivity.class);
                        //                      context.startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getBodyMassIndex(Context context, TextView result, double weight, double height) {
        CalculatorsRequest calculatorsRequest = new CalculatorsRequest(weight, height);
        Call<CalculatorsResponse> c = client.bmiIndex(calculatorsRequest);
        c.enqueue(new Callback<CalculatorsResponse>() {
            @SuppressLint({"DefaultLocale"})
            @Override
            public void onResponse(@NotNull Call<CalculatorsResponse> call, @NotNull Response<CalculatorsResponse> response) {
                if (response.isSuccessful()) {
                    result.setText(String.format("%.2f", response.body().getResult()));
                    String message = response.body().getMessage();

                    if (message.equals(context.getString(R.string.severe_underweight))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.severeUnderweight));

                    } else if (message.equals(context.getString(R.string.underweight))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.underweight));

                    } else if (message.equals(context.getString(R.string.norm))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.norm));

                    } else if (message.equals(context.getString(R.string.overweight))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.overweight));

                    } else if (message.equals(context.getString(R.string.obesity))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.obesity));

                    } else if (message.equals(context.getString(R.string.acute_obesity))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.acuteObesity));

                    } else if (message.equals(context.getString(R.string.very_severe_obesity))) {
                        result.setTextColor(ContextCompat.getColor(context, R.color.verySevereObesity));
                    }
                }
            }
            @Override
            public void onFailure(@NotNull Call<CalculatorsResponse> call, @NotNull Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDailyWaterAmount(Context context, TextView result, double weight) {
        CalculatorsRequest calculatorsRequest = new CalculatorsRequest(weight);
        Call<CalculatorsResponse> c = client.dwr(calculatorsRequest);
        c.enqueue(new Callback<CalculatorsResponse>() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onResponse(@NotNull Call<CalculatorsResponse> call, @NotNull Response<CalculatorsResponse> response) {
                if (response.isSuccessful()) {
                    result.setText(String.format("%.2f", response.body().getResult()) + " " + context.getString(R.string.ml));
                }
            }
            @Override
            public void onFailure(@NotNull Call<CalculatorsResponse> call, @NotNull Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getIdealWeight(Context context, TextView result, String gender, double height) {
        CalculatorsRequest calculatorsRequest = new CalculatorsRequest(height, gender);
        Call<CalculatorsResponse> c = client.idealWeight(calculatorsRequest);
        c.enqueue(new Callback<CalculatorsResponse>() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onResponse(Call<CalculatorsResponse> call, Response<CalculatorsResponse> response) {
                if (response.isSuccessful()) {
                    result.setText(String.format("%.2f", response.body().getResult()) + " " + context.getString(R.string.kg));
                }
            }
            @Override
            public void onFailure(Call<CalculatorsResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getDailyCaloriesAmount(Context context, TextView result, String gender, double weight, double height, double age,
                                       String loadFactor) {
        CalculatorsRequest calculatorsRequest = new CalculatorsRequest(gender, weight, height, age, loadFactor);
        Call<CalculatorsResponse> c = client.dailyCalories(calculatorsRequest);
        c.enqueue(new Callback<CalculatorsResponse>() {
            @SuppressLint({"DefaultLocale", "SetTextI18n"})
            @Override
            public void onResponse(Call<CalculatorsResponse> call, Response<CalculatorsResponse> response) {
                if (response.isSuccessful()) {
                    result.setText(String.format("%.0f", response.body().getResult()) + " " + context.getString(R.string.calories));
                }
            }

            @Override
            public void onFailure(Call<CalculatorsResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveStepsCall(Context context, Integer stepsAmount, String date) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(String.valueOf(stepsAmount), date);
        Call<JournalResponse> c = client.saveSteps(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                //Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveCaloriesCall(Context context, Integer caloriesAmount, String date) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(String.valueOf(caloriesAmount), date);
        Call<JournalResponse> c = client.saveCalories(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                // Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void saveDistanceCall(Context context, Integer distanceAmount, String date) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(String.valueOf(distanceAmount), date);
        Call<JournalResponse> c = client.saveDistance(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                // Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void saveWeightCall(Context context, Integer weight, String date) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(String.valueOf(weight), date);
        Call<JournalResponse> c = client.saveWeight(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                //Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getSteps(Context context, String startDate) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(startDate);
        Call<JournalResponse> c = client.getSteps(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                StepsJournalActivity.journalResponses = response.body().getJournal();
                Intent intent = new Intent(context, StepsJournalActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getWeight(Context context, String startDate) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(startDate);
        Call<JournalResponse> c = client.getWeight(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                WeightJournalActivity.weightJournal = response.body().getJournal();
                Intent intent = new Intent(context, WeightJournalActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getCalories(Context context, String startDate) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(startDate);
        Call<JournalResponse> c = client.getCalories(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                CaloriesJournalActivity.caloriesJournal = response.body().getJournal();
                Intent intent = new Intent(context, CaloriesJournalActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void getDistance(Context context, String startDate) {
        JournalSaveRequest journalSaveRequest = new JournalSaveRequest(startDate);
        Call<JournalResponse> c = client.getDistance(journalSaveRequest);
        c.enqueue(new Callback<JournalResponse>() {
            @Override
            public void onResponse(Call<JournalResponse> call, Response<JournalResponse> response) {
                DistanceJournalActivity.distanceJournal = response.body().getJournal();
                Intent intent = new Intent(context, DistanceJournalActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<JournalResponse> call, Throwable t) {
                Toast.makeText(context, context.getText(R.string.on_failure), Toast.LENGTH_SHORT).show();
            }
        });
    }
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
