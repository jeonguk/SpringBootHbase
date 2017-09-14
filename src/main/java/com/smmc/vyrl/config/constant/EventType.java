package com.smmc.vyrl.config.constant;

public enum EventType {

    normal(Constants.EVENT_TYPE_NORMAL, "Normal storage log"),
    middleware_opt(Constants.EVENT_TYPE_MIDDLEWARE_OPT, "Middleware operation");

    private String symbol;

    private String label;

    private  EventType(String symbol, String label) {
        this.symbol = symbol;
        this.label = label;
    }

    public  String symbol() {
        return this.symbol;
    }

    public  String label() {
        return this.label;
    }

}