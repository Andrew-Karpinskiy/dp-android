package com.example.diplomandroid.repository.retrofit.response;

import java.util.Map;

public class JournalResponse {
    private String message;
    private Map<String, String> journal;

    public JournalResponse(String message) {
        this.message = message;
    }

    public JournalResponse(Map<String, String> journal) {
        this.journal = journal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getJournal() {
        return journal;
    }

    public void setJournal(Map<String, String> journal) {
        this.journal = journal;
    }
}
