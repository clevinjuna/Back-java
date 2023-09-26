package fr.mns.java.rest.dto;

import fr.mns.java.rest.model.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class CommentDTO {
    private Long id;
    private User user;
    private String content;
    private Post post;
    private LocalDateTime date;

    public CommentDTO(Long id, User user, String content, Post post, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.post = post;
        this.date = date;
    }

    public CommentDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
