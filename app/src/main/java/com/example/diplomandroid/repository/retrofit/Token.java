package com.example.diplomandroid.repository.retrofit;

public class Token {
    private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        Token.token = "Bearer " + token;
    }
}
