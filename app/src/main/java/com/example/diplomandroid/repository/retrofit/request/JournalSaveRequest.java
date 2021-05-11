package com.example.diplomandroid.repository.retrofit.request;

public class JournalSaveRequest {
    private String amount;
    private String date;

    public JournalSaveRequest(String amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public JournalSaveRequest(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}