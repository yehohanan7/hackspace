package com.hackspace.common;


public class ClojureService {

    private String key;

    public String user = "";

    public ClojureService(String key) {
        this.key = key;
    }
    public static String loopBack(String input) {
        return input;
    }

    public String key() {
        return key;
    }

    public void changeKey(String key) {
        this.key = key;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
