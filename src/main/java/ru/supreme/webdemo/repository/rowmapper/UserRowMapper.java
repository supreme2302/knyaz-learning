package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.entity.UserEntity;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    public UserEntity mapRow(ResultSet resultSet) throws SQLException {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getLong("user_id"));
        userEntity.setUsername(resultSet.getString("username"));
        if (resultSet.getString("username") == null) {
            return null;
        }
        userEntity.setPassword(resultSet.getString("password"));
        return userEntity;
    }
}
