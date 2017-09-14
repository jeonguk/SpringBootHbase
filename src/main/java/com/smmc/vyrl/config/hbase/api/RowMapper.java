package com.smmc.vyrl.config.hbase.api;

import org.apache.hadoop.hbase.client.Result;

/**
 * @desc copy from spring data hadoop hbase, modified
 */
public interface RowMapper<T> {

    T mapRow(Result result, int rowNum) throws Exception;
}