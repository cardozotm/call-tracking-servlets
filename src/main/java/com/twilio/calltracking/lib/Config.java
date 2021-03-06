package com.twilio.calltracking.lib;

public class Config {

    public static String getAccountSid() {

        return System.getenv("TWILIO_ACCOUNT_SID");
    }

    public static String getAuthToken() {

        return System.getenv("TWILIO_AUTH_TOKEN");
    }

    public static String getTwimlApplicationSid() {
        return System.getenv("TWILIO_APP_SID");
    }
}
