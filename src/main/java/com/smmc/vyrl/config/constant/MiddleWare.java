package com.smmc.vyrl.config.constant;

public enum MiddleWare {
    HBASE(Constants.MIDDLEWARE_HBASE, "hbase");

    private String symbol;

    private String label;

    private  MiddleWare(String symbol, String label) {
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
