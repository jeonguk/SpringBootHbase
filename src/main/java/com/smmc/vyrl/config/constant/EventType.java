package com.smmc.vyrl.config.constant;

public enum EventType {

    normal(Constants.EVENT_TYPE_NORMAL, "正常入库日志"),
    invoke_interface(Constants.EVENT_TYPE_INVOKE_INTERFACE, "api调用"),
    middleware_opt(Constants.EVENT_TYPE_MIDDLEWARE_OPT, "中间件操作"),
    job_execute(Constants.EVENT_TYPE_JOB_EXECUTE, "job执行状态"),
    custom_log(Constants.EVENT_TYPE_CUSTOM_LOG, "自定义埋点日志"),
    rpc_trace(Constants.EVENT_TYPE_RPC_TRACE, "rpc trace跟踪日志"),
    thirdparty_call(Constants.EVENT_TYPE_THIRDPARTY_CALL, "第三方系统调用");

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