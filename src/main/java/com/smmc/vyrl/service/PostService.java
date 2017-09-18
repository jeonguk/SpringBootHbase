package com.smmc.vyrl.service;

import com.smmc.vyrl.config.hbase.api.HbaseTemplate;
import com.smmc.vyrl.domain.Post;
import com.smmc.vyrl.util.SerializationUtil;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PostService {

    @Autowired
    private Configuration hbaseAutoConfiguration;

    @Autowired
    private HbaseTemplate hbaseTemplate;

    // Table info
    private TableName postTable = TableName.valueOf("post_table");
    private final String columnFamily = "cf1";

    public void createPostTable() throws Exception {
        HBaseAdmin admin = new HBaseAdmin(hbaseAutoConfiguration);

        if (admin.tableExists(postTable)) {
            System.out.println("Table Already Created");
        } else {
            HTableDescriptor tableDesc = new HTableDescriptor(postTable);
            tableDesc.addFamily(new HColumnDescriptor(columnFamily));
            admin.createTable(tableDesc);
        }
    }

    @Autowired
    org.springframework.data.hadoop.hbase.HbaseTemplate template;

    /**
     * Read data from HBase table
     */
    public Post getPostData(String postId) {
        return template.execute("post_table", new TableCallback<Post>() {

            @Override
            public Post doInTable(HTableInterface table) throws Throwable {
                Get get = new Get(Bytes.toBytes(postId));
                Result result = table.get(get);
                byte [] value = result.getValue(Bytes.toBytes("cf1"), Bytes.toBytes("cf1"));
                Post post = new Post();
                SerializationUtil.deserialize(value, post);
                return post;
            }
        });
    }

    /**
     * Write data into HBase table
     */
    public void putPostData() throws TException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        Post post = new Post();
        post.setId("123456789");
        post.setWriter("JEONGUK");
        post.setTitle("POST TITLE 1111111");
        post.setContent("POST CONTENT 111111");

        Put p = new Put(Bytes.toBytes(post.getId() + timestamp.getTime()));
        p.add(columnFamily.getBytes(), columnFamily.getBytes(), SerializationUtil.serialize(post));

        this.hbaseTemplate.saveOrUpdate("post_table", p);
    }


    /**
     * Write data into HBase table
     */
    public void putData() {

        template.execute("post_table", new TableCallback<Post>() {

            public Post doInTable(HTableInterface table) throws Throwable {

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                Post post = new Post();
                post.setId("123456790");
                post.setWriter("JEONGUK2");
                post.setTitle("POST TITLE 222222");
                post.setContent("POST CONTENT 2222222");

                //create a put with row key
                Put p = new Put(Bytes.toBytes(post.getId() + timestamp.getTime()));
                //add row value
                p.add(Bytes.toBytes("cf1"), Bytes.toBytes("cf1"), SerializationUtil.serialize(post));
                table.put(p);
                return post;
            }
        });

    }

}
