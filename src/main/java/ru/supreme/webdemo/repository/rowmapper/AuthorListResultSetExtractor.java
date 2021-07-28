package ru.supreme.webdemo.repository.rowmapper;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import ru.supreme.webdemo.model.AuthorEntity;
import ru.supreme.webdemo.model.BookEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Вынес для удобства resultSetExtractor в отдельный класс и объявил его бином
 */
@Component
public class AuthorListResultSetExtractor implements ResultSetExtractor<List<AuthorEntity>> {

    private final AuthorRowMapper authorRowMapper;
    private final BookRowMapper bookRowMapper;

    /**
     * Поскольку этот класс является бином, то мы можем заинжектить в него другие бины
     */
    public AuthorListResultSetExtractor(AuthorRowMapper authorRowMapper,
                                    BookRowMapper bookRowMapper) {
        this.authorRowMapper = authorRowMapper;
        this.bookRowMapper = bookRowMapper;
    }

    @Override
    public List<AuthorEntity> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, AuthorEntity> authors = new LinkedHashMap<>();
        while (rs.next()) {
            long id = rs.getLong("author_id");
//            authors.computeIfAbsent(id, value -> {
//                AuthorEntity authorEntity;
//                try {
//                    authorEntity = authorRowMapper.mapRow(rs);
//                    authorEntity.setBooks(new ArrayList<>());
//                } catch (SQLException e) {
//                    throw new RuntimeException(e);
//                }
//                return authorEntity;
//            });

            /**
             * Мои попытки переписать по-другому
             */

            if (!(authors.containsKey(id))) {
                AuthorEntity authorEntity;
                authorEntity = authorRowMapper.mapRow(rs);
                authorEntity.setBooks(new ArrayList<>());
                authors.put(id, authorEntity);
            }

            AuthorEntity authorEntity = authors.get(id);
            BookEntity bookEntity = bookRowMapper.mapRow(rs);
            authorEntity.getBooks().add(bookEntity);
        }
        return new ArrayList<>(authors.values());
    }
}
