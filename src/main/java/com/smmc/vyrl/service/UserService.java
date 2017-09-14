package com.smmc.vyrl.service;

import com.smmc.vyrl.config.hbase.api.HbaseTemplate;
import com.smmc.vyrl.domain.User;
import com.smmc.vyrl.rowmapper.UserRowMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private Configuration hbaseAutoConfiguration;

    @Autowired
    private HbaseTemplate hbaseTemplate;

    // Table info
    final String tableName = "user_table";
    final String columnFamilyData = "data";

    public void createTable() throws Exception {
        HBaseAdmin admin = new HBaseAdmin(hbaseAutoConfiguration);

        if (admin.tableExists(tableName)) {
            //admin.disableTable(tableName);
            //admin.deleteTable(tableName);
            System.out.println("Table Already Created");
        } else {

            HTableDescriptor tableDes = new HTableDescriptor(Bytes.toBytes(tableName));
            HColumnDescriptor cf1 = new HColumnDescriptor(Bytes.toBytes(columnFamilyData));
            tableDes.addFamily(cf1);
            admin.createTable(tableDes);
        }
    }

    public List<User> query(String startRow, String stopRow) {
        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(stopRow));
        scan.setCaching(5000);
        List<User> dtos = this.hbaseTemplate.find("user_table", scan, new UserRowMapper());
        return dtos;
    }

    public User query(String row) {
        User dto = this.hbaseTemplate.get("user_table", row, new UserRowMapper());
        return dto;
    }

    public void saveOrUpdates() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        List<Mutation> puts = new ArrayList<>();
        // create a put with row key
        Put p = new Put(Bytes.toBytes("jeonguk" + timestamp.getTime()));
        //add row value
        p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("firstName"), Bytes.toBytes("JEONGUK" + timestamp.getTime()));
        p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("lastName"), Bytes.toBytes("LEE" + timestamp.getTime()));
        //p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("age"), Bytes.toBytes("25"));

        puts.add(p);
        // 设值
        this.hbaseTemplate.saveOrUpdates("user_table", puts);
    }

    public void saveUpdate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // create a put with row key
        Put p = new Put(Bytes.toBytes("jeonguk" + timestamp.getTime()));
        //add row value
        p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("firstName"), Bytes.toBytes("JEONGUK" + timestamp.getTime()));
        p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("lastName"), Bytes.toBytes("LEE" + timestamp.getTime()));
        //p.addColumn(Bytes.toBytes("data"), Bytes.toBytes("age"), Bytes.toBytes("25"));

        // 设值
        this.hbaseTemplate.saveOrUpdate("user_table", p);
    }

    public void saveOrUpdate() {
        Mutation delete = new Delete(Bytes.toBytes(""));
        this.hbaseTemplate.saveOrUpdate("user_table", delete);
    }
}
