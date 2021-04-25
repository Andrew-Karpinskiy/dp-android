package com.example.diplomandroid.repository.retrofit.request;

public class JournalSaveRequest {
    private String amount;

    public JournalSaveRequest(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}