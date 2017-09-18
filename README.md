# SpringBootHbase
- hbase remote call 

```
- Oracle VM
- CentOS 6.9
```

### HBase Standalone 설치 &  사용법

$ wget http://apache.mirror.cdnetworks.com/hbase/stable/hbase-1.2.6-bin.tar.gz

### 2. 압축 해제 및 /usr/local에 복사 설치

```
$ tar -xzvf hbase-1.1.5-bin.tar.gz
$ cp -rf hbase-1.1.5 /usr/local
```

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
$ export JAVA_HOME=/usr/java/jdk1.8
$ export HBASE_HOME=/usr/local/hbase-1.2.6
$ export PATH=$PATH:$JAVA_HOME/bin:$HBASE_HOME/bin
```
### 5. HBase의 설정 편집
```
$ cd $HBASE_HOME
$ vi conf/hbase-site.xml
```

![Alt text](https://user-images.githubusercontent.com/1449153/30422158-0d8e8ae6-997a-11e7-97b1-81544d186585.png "hbae-site")


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

