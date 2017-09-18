package com.smmc.vyrl.config.hbase;

import com.smmc.vyrl.config.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@org.springframework.context.annotation.Configuration
@EnableConfigurationProperties(HbaseProperties.class)
@ConditionalOnClass(HbaseTemplate.class)
public class HbaseAutoConfiguration {

    private static final String HBASE_QUORUM = "hbase.zookeeper.quorum";
    private static final String HBASE_ROOTDIR = "hbase.rootdir";
    private static final String HBASE_ZNODE_PARENT = "zookeeper.znode.parent";

    @Autowired
    private HbaseProperties hbaseProperties;

    @Bean
    @ConditionalOnMissingBean(HbaseTemplate.class)
    public HbaseTemplate hbaseTemplate() {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
        configuration.set(HBASE_ROOTDIR, this.hbaseProperties.getRootDir());
        configuration.set(HBASE_ZNODE_PARENT, this.hbaseProperties.getNodeParent());
        return new HbaseTemplate(configuration);
    }

    @Bean
    public Configuration configuration() {
        Configuration configuration = HBaseConfiguration.create();
        configuration.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
        configuration.set(HBASE_ROOTDIR, this.hbaseProperties.getRootDir());
        configuration.set(HBASE_ZNODE_PARENT, this.hbaseProperties.getNodeParent());
        return  configuration;
    }

    @Bean
    @Qualifier("originalHbaseTemplate")
    org.springframework.data.hadoop.hbase.HbaseTemplate baseTemplate() {
        Configuration conf = HBaseConfiguration.create();
        conf.set(HBASE_QUORUM, this.hbaseProperties.getQuorum());
        conf.set(HBASE_ROOTDIR, this.hbaseProperties.getRootDir());
        conf.set(HBASE_ZNODE_PARENT, this.hbaseProperties.getNodeParent());
        return new org.springframework.data.hadoop.hbase.HbaseTemplate(conf);
    }
}
