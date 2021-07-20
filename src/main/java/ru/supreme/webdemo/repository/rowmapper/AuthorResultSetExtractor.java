package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.AuthorEntity;
import ru.supreme.webdemo.model.BookEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Вынес для удобства resultSetExtractor в отдельный класс и объявил его бином
 */
@Component
public class AuthorResultSetExtractor implements ResultSetExtractor<AuthorEntity> {

    private final AuthorRowMapper authorRowMapper;
    private final BookRowMapper bookRowMapper;

    /**
     * Поскольку этот класс является бином, то мы можем заинжектить в него другие бины
     */
    public AuthorResultSetExtractor(AuthorRowMapper authorRowMapper,
                                        BookRowMapper bookRowMapper) {
        this.authorRowMapper = authorRowMapper;
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public AuthorEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<BookEntity> bookEntityList = new ArrayList<>();
        AuthorEntity authorEntity = null;
        while (rs.next()) {
            if (authorEntity == null) {
                authorEntity = authorRowMapper.mapRow(rs);
            }
            BookEntity bookEntity = bookRowMapper.mapRow(rs);
            bookEntityList.add(bookEntity);
        }
        if (authorEntity != null) {
            authorEntity.setBooks(bookEntityList);
        }
        return authorEntity;
    }
}
