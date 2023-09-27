package fr.mns.java.rest.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mns.java.rest.model.Person;
import fr.mns.java.rest.model.Post;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class PostDTO {
    private Long id;
    private String content;
    private Person author;

    private LocalDateTime date;

    public PostDTO(Long id, String content, Person author, LocalDateTime date) {
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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public static PostDTO fromJsonString(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, PostDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}