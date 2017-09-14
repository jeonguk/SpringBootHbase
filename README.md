# SpringBootHbase
- hbase remote call 

```
- Oracle VM
- CentOS 6.9
```

### HBase Standalone 설치 &  사용법

$ wget http://apache.mirror.cdnetworks.com/hbase/stable/hbase-1.2.6-bin.tar.gz

2. 압축 해제 및 /usr/local에 복사 설치
$ tar -xzvf hbase-1.1.5-bin.tar.gz
$ cp -rf hbase-1.1.5 /usr/local
```
/usr/local

### 3. 하둡용 계정 생성과 비밀번호 변경 및 HBase 사용자로 설정
```
useradd hadoop
passwd hadoop
passwod : hadoopuser
```
```
chown -R hadoop.hadoop habase-1.2.6
```

### 4. .bash_profile에 JAVA_HOME과 HBASE_HOME 설정
```
$ su - hadoop
$ export JAVA_HOME=/usr/java/jsk1.8.0_60
$ export HBASE_HOME=/usr/local/hbase-1.1.5
$ export PATH=$PATH:$JAVA_HOME/bin:$HBASE_HOME/bin
```
### 5. HBase의 설정 편집
```
$ cd $HBASE_HOME
$ vi conf/hbase-site.xml
```

```
<!-- conf/hbase-site.xml 내용 -->
<configuration>
  <property>
    <name>hbase.rootdir</name>
    <value>file:///home/hadoop/dataRepository</value>
  </property>
  <property>
    <name>hbase.zookeeper.property.dataDir</name>
    <value>/home/hadoop/zookeeper</value>
  </property>
  <property>
    <name>hbase.zookeeper.quorum</name>
    <value>192.168.56.101</value>
  </property>
  <property>
    <name>hbase.zookeeper.property.clientPort</name>
    <value>2181</value>
  </property>
  <property>
    <name>zookeeper.znode.parent</name>
    <value>/home/hadoop/hbase-unsecure</value>
  </property>
  <property>
    <name>zookeeper.security.authentication</name>
    <value>simple</value>
  </property>
</configuration>
```

### 6. 데이터 저장소 경로 생성
```
$ mkdir /home/hadoop/dataRepository
$ mkdir /home/hadoop/zookeeper
```

### 7. HBase 구동과 대화형 쉘 실행
```
$ ./bin/start-hbase.sh
$ ./bin/hbase shell
```

### 8. 테이블 생성과 확인

### 대화형 쉘 종료
```
hbase(main):013:0> quit
```


## * 서버 host와 localhost를 맞춰서 수정



# HBASE DATA

![Alt text](https://user-images.githubusercontent.com/1449153/30421867-18ead5d0-9979-11e7-9947-ecc3a39a656f.png "save data list")



