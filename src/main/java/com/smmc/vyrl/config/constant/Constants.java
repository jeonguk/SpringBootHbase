package com.smmc.vyrl.config.constant;

public class Constants {

    public static final String VERTICAL_LINE = "|";
    public static final String VERTICAL_LINE_SPLIT = "\\|";

    public static final String TABLE_ANNOTATION_COLUMN_FAMILY = "trace";
    public static final String TABLE_TIME_CONSUME_COLUMN_FAMILY = TABLE_ANNOTATION_COLUMN_FAMILY;


    // 로그 유형
    public static final String EVENT_TYPE_NORMAL = "normal";
    public static final String EVENT_TYPE_INVOKE_INTERFACE = "invoke_interface";
    public static final String EVENT_TYPE_MIDDLEWARE_OPT = "middleware_opt";
    public static final String EVENT_TYPE_JOB_EXECUTE = "job_execute";
    public static final String EVENT_TYPE_CUSTOM_LOG = "custom_log";
    public static final String EVENT_TYPE_RPC_TRACE = "rpc_trace";
    public static final String EVENT_TYPE_THIRDPARTY_CALL = "thirdparty_call";

    // 미들웨어
    public static final String MIDDLEWARE_HBASE = "hbase";


}
