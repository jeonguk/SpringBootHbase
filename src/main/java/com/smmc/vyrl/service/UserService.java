package com.smmc.vyrl.service;

import com.smmc.vyrl.config.hbase.api.HbaseTemplate;
import com.smmc.vyrl.domain.User;
import com.smmc.vyrl.rowmapper.UserRowMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
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
    private TableName tableName = TableName.valueOf("user_table");
    private final String columnFamily1 = "Family1";
    private final String columnFamily2 = "Family2";

    private final byte[] firstName = Bytes.toBytes("firstName");
    private final byte[] lastName = Bytes.toBytes("lastName");
    private final byte[] email = Bytes.toBytes("email");
    private final byte[] address = Bytes.toBytes("address");
    private final byte[] follow = Bytes.toBytes("follow");

    public void createTable() throws Exception {
        HBaseAdmin admin = new HBaseAdmin(hbaseAutoConfiguration);

        if (admin.tableExists(tableName)) {
            //admin.disableTable(tableName);
            //admin.deleteTable(tableName);
            System.out.println("Table Already Created");
        } else {
            HTableDescriptor tableDes = new HTableDescriptor(tableName);
            tableDes.addFamily(new HColumnDescriptor(columnFamily1));
            tableDes.addFamily(new HColumnDescriptor(columnFamily2));
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
        p.addImmutable(columnFamily1.getBytes(), firstName, Bytes.toBytes("JEONGUK"));
        p.addImmutable(columnFamily1.getBytes(), lastName, Bytes.toBytes("LEE" ));
        p.addImmutable(columnFamily1.getBytes(), email, Bytes.toBytes("jeonguk@gmail.com"));
        p.addImmutable(columnFamily1.getBytes(), address, Bytes.toBytes("Seoul Korea"));

        p.addImmutable(columnFamily2.getBytes(), follow, Bytes.toBytes("LEE JOENGUK"));

        puts.add(p);
        // 设值
        this.hbaseTemplate.saveOrUpdates("user_table", puts);
    }

    public void saveUpdate() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // create a put with row key
        Put p = new Put(Bytes.toBytes("jeonguk" + timestamp.getTime()));
        //add row value
        p.addImmutable(columnFamily1.getBytes(), firstName, Bytes.toBytes("JEONGUK"));
        p.addImmutable(columnFamily1.getBytes(), lastName, Bytes.toBytes("LEE" ));
        p.addImmutable(columnFamily1.getBytes(), email, Bytes.toBytes("jeonguk@gmail.com"));
        p.addImmutable(columnFamily1.getBytes(), address, Bytes.toBytes("Seoul Korea"));

        p.addImmutable(columnFamily2.getBytes(), follow, Bytes.toBytes("LEE JOENGUK"));

        // 设值
        this.hbaseTemplate.saveOrUpdate("user_table", p);
    }

    public void saveOrUpdate() {
        Mutation delete = new Delete(Bytes.toBytes(""));
        this.hbaseTemplate.saveOrUpdate("user_table", delete);
    }
}
