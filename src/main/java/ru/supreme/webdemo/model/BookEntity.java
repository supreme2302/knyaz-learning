package ru.supreme.webdemo.model;

import java.sql.Timestamp;

public class BookEntity {

    private Long id;

    private String title;

    private Long authorId;

    private Timestamp date;

    public BookEntity() {
    }

    public BookEntity(Long id, String title, Long authorId, Timestamp date) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.authorId = authorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", date=" + date +
                '}';
    }
}
