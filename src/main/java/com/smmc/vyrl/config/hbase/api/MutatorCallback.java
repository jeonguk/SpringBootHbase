package com.smmc.vyrl.config.hbase.api;

import org.apache.hadoop.hbase.client.BufferedMutator;

/**
 * @desc callback for hbase put delete and update
 */
public interface MutatorCallback {

    /**
     * use mutator api to update put and delete
     * @param mutator
     * @throws Throwable
     */
    void doInMutator(BufferedMutator mutator) throws Throwable;
}