package fr.mns.java.rest.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mns.java.rest.model.Person;
import fr.mns.java.rest.model.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class CommentDTO {
    private Long id;
    private Person author;
    private String content;
    private Post post;
    private LocalDateTime date;

    public CommentDTO(Long id, Person author, String content, Post post, LocalDateTime date) {
        this.id = id;
        this.author = author;
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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
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

    public static CommentDTO fromJsonString(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, CommentDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
