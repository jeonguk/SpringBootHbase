package com.smmc.vyrl.rowmapper;

import com.smmc.vyrl.config.hbase.api.RowMapper;
import com.smmc.vyrl.domain.User;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class UserRowMapper implements RowMapper<User> {

    private static byte[] COLUMNFAMILY1 = "Family1".getBytes();
    private static byte[] FIRST_NAME = "firstName".getBytes();
    private static byte[] LAST_NAME = "lastName".getBytes();
    private static byte[] EMAIL = "email".getBytes();
    private static byte[] ADDRESS = "address".getBytes();

    private static byte[] COLUMNFAMILY2 = "Family2".getBytes();
    private static byte[] FOLLOW = "follow".getBytes();

    @Override
    public User mapRow(Result result, int rowNum) throws Exception {
        User dto = new User();
        // TODO: 연관된 속성 값 설정
        String firstName = Bytes.toString(result.getValue(COLUMNFAMILY1, FIRST_NAME));
        String lastName = Bytes.toString(result.getValue(COLUMNFAMILY1, LAST_NAME));
        String email = Bytes.toString(result.getValue(COLUMNFAMILY1, EMAIL));
        String address = Bytes.toString(result.getValue(COLUMNFAMILY1, ADDRESS));

        String follow = Bytes.toString(result.getValue(COLUMNFAMILY2, FOLLOW));
        return dto.setFirstName(firstName).setLastName(lastName).setEmail(email).setAddress(address).setFollow(follow);
    }

}
