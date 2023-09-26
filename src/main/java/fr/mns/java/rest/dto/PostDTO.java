package fr.mns.java.rest.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDTO {
    private Long id;
    private String content;
    private User author;

    private LocalDateTime date;

    public PostDTO(Long id, String content, User author, LocalDateTime date) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public PostDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}