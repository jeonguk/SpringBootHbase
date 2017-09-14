package com.smmc.vyrl.config.hbase.dto;

import com.smmc.vyrl.config.constant.Constants;
import com.smmc.vyrl.config.constant.EventType;

public class EventLog {

    // 이벤트 로그 성공 또는 실패
    public static final String MONITOR_STATUS_SUCCESS = "success";
    public static final String MONITOR_STATUS_FAILED = "failed";

    // 로그 이벤트 유형
    protected EventType eventType;
    // 로그 이벤트 이름，
    // 호출이 api로 설정된 경우，태스크 스케줄 인 경우 appId로 설정. 타사 시스템 인 경우 타사 도킹 이름으로 설정. 미들웨어로 설정된 경우
    protected String uniqueName;
    // 시간이 많이 소요되는 로그 설정을 계산하는 데 시간이 필요, 밀리 세컨즈
    protected long cost;

    protected String status;
    // 특정 로그 내용
    protected String log;


    protected  EventLog() {

    }

    /**
     * eventlog
     * @param eventType
     * @param log
     * @return
     */
    public static  EventLog buildEventLog(EventType eventType, String uniqueName, long cost, String status, String log) {
        EventLog eventLog = new EventLog();
        eventLog.setEventType(eventType);
        eventLog.setUniqueName(uniqueName);
        eventLog.setCost(cost);
        eventLog.setStatus(status);
        eventLog.setLog(log);
        return eventLog;
    }

    /**
     * 로그 내용을 기반으로 로그 분석
     * @param line
     * @return
     */
    public static  EventType parseEventType(String line) {
        if (line.indexOf(Constants.VERTICAL_LINE) == -1) {
            return EventType.normal;
        } else {
            String[] detail = line.split(Constants.VERTICAL_LINE_SPLIT);
            try {
                return EventType.valueOf(detail[0]);
            } catch (Exception e) {
                return EventType.normal;
            }
        }
    }

    /**
     * 문자열에 따라 EventLog를 구문 분석
     * @param line
     * @return
     */
    public static  EventLog parseEventLog(String line) {
        String[] detail = line.split(Constants.VERTICAL_LINE_SPLIT);
        return buildEventLog(EventType.valueOf(detail[0]), detail[1], Long.parseLong(detail[2]), detail[3], detail[4]);
    }

    @Override
    public  String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.eventType.symbol());
        sb.append(Constants.VERTICAL_LINE);
        sb.append(this.uniqueName);
        sb.append(Constants.VERTICAL_LINE);
        sb.append(this.cost);
        sb.append(Constants.VERTICAL_LINE);
        sb.append(this.status);
        sb.append(Constants.VERTICAL_LINE);
        sb.append(this.log);
        return sb.toString();
    }

    public  EventType getEventType() {
        return eventType;
    }

    public  void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public  String getUniqueName() {
        return uniqueName;
    }

    public  void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    public  long getCost() {
        return cost;
    }

    public  void setCost(long cost) {
        this.cost = cost;
    }

    public  String getStatus() {
        return status;
    }

    public  void setStatus(String status) {
        this.status = status;
    }

    public  String getLog() {
        return log;
    }

    public  void setLog(String log) {
        this.log = log;
    }
}