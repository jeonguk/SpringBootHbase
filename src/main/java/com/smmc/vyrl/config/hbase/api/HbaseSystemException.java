package com.smmc.vyrl.config.hbase.api;

import org.springframework.dao.UncategorizedDataAccessException;

/**
 * @desc copy from spring data hadoop hbase, modified
 */
public class HbaseSystemException extends UncategorizedDataAccessException {

    public  HbaseSystemException(Exception cause) {
        super(cause.getMessage(), cause);
    }

    public  HbaseSystemException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
}