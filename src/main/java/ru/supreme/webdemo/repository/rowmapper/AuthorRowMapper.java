package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.AuthorEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Вынес для удобства rowMapper в отдельный класс и объявил его бином
 */
@Component
public class AuthorRowMapper implements RowMapper<AuthorEntity> {

    @Override
    public AuthorEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    /**
     * Для удобства перегрузил метод mapRow и сделал его с одним параметром, поскольку номер строки нам не нужен.
     * Этот метод будет вызываться в резалт сет эксракторе
     */
    public AuthorEntity mapRow(ResultSet resultSet) throws SQLException {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(resultSet.getLong("author_id"));
        authorEntity.setName(resultSet.getString("name"));
        // authorEntity.setBooks мы не можем установить здесь
        return authorEntity;
    }
}
