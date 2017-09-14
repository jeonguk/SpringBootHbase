package com.smmc.vyrl.rowmapper;

import com.smmc.vyrl.config.hbase.api.RowMapper;
import com.smmc.vyrl.domain.User;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

public class UserRowMapper implements RowMapper<User> {

    private static byte[] COLUMNFAMILY = "data".getBytes();
    private static byte[] FIRST_NAME = "firstName".getBytes();
    private static byte[] LAST_NAME = "lastName".getBytes();

    @Override
    public User mapRow(Result result, int rowNum) throws Exception {
        User dto = new User();
        // TODO: 연관된 속성 값 설정
        String firstName = Bytes.toString(result.getValue(COLUMNFAMILY, FIRST_NAME));
        String lastName = Bytes.toString(result.getValue(COLUMNFAMILY, LAST_NAME));

        return dto.setFirstName(firstName).setLastName(lastName);
    }

}
