package com.example.diplomandroid.repository.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CalculatorsResponse {
    @SerializedName("result")
    @Expose
    private double result;
    @SerializedName("message")
    @Expose
    private String message;

    public CalculatorsResponse(double result) {
        this.result = result;
    }

    public CalculatorsResponse(double result, String message) {
        this.result = result;
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
