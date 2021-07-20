package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.BookEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Вынес для удобства rowMapper в отдельный класс и объявил его бином
 */
@Component
public class BookRowMapper implements RowMapper<BookEntity> {

    @Override
    public BookEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return mapRow(resultSet);
    }

    /**
     * Для удобства перегрузил метод mapRow и сделал его с одним параметром, поскольку номер строки нам не нужен.
     * Этот метод будет вызываться в резалт сет эксракторе
     */
    public BookEntity mapRow(ResultSet resultSet) throws SQLException {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(resultSet.getLong("book_id"));
        bookEntity.setTitle(resultSet.getString("title"));
        bookEntity.setAuthorId(resultSet.getLong("author_id"));
        bookEntity.setDate(resultSet.getTimestamp("date"));
        return bookEntity;
    }
}
