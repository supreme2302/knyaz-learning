package ru.supreme.webdemo.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.supreme.webdemo.model.AuthorEntity;
import ru.supreme.webdemo.repository.AuthorRepository;
import ru.supreme.webdemo.repository.rowmapper.AuthorListResultSetExtractor;
import ru.supreme.webdemo.repository.rowmapper.AuthorResultSetExtractor;

import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    private final JdbcTemplate jdbcTemplate;
    private final AuthorListResultSetExtractor authorListResultSetExtractor;
    private final AuthorResultSetExtractor authorResultSetExtractor;

    public AuthorRepositoryImpl(JdbcTemplate jdbcTemplate,
                                AuthorListResultSetExtractor authorListResultSetExtractor,
                                AuthorResultSetExtractor authorResultSetExtractor) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorListResultSetExtractor = authorListResultSetExtractor;
        this.authorResultSetExtractor = authorResultSetExtractor;
    }

    @Override
    public List<AuthorEntity> findAll() {
        return jdbcTemplate.query("select a.id as author_id, a.name, b.id book_id, b.title, b.date from author a " +
                        "join book b on a.id = b.author_id ",
                authorListResultSetExtractor);
    }

    @Override
    public AuthorEntity findById(Long id) {
        return jdbcTemplate.query("select a.id as author_id, a.name, b.id book_id, b.title, b.date from author a " +
                        "join book b on a.id = b.author_id " +
                        "where a.id = ?",
                authorResultSetExtractor, id);
    }

    @Override
    public void save(AuthorEntity employeeEntity) {

    }

    @Override
    public void delete(Long id) {

    }
}
