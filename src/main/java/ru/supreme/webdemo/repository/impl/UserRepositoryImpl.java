package ru.supreme.webdemo.repository.impl;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.entity.UserEntity;
import ru.supreme.webdemo.repository.UserRepository;
import ru.supreme.webdemo.repository.rowmapper.UserRowMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final UserRowMapper userRowMapper;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        UserEntity userEntity;
        try {
            userEntity = jdbcTemplate.queryForObject("select id as user_id, username, password from users" +
                            " where username = ?",
                    userRowMapper,
                    username);
        } catch (EmptyResultDataAccessException exception) {
            return null;
        }
        return userEntity;
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        jdbcTemplate.update("insert into users (username, password) values (?, ?)",
                userEntity.getUsername(),
                userEntity.getPassword());
        return userEntity;
    }
}
