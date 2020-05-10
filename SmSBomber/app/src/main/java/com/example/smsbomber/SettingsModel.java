package com.example.smsbomber;

public class SettingsModel {
    private String message;
    public SettingsModel(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
