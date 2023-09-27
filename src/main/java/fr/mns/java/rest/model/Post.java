package fr.mns.java.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.mns.java.rest.dto.PostDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="content", length=2047)
    private String content;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Person author;
    @Column(name="published")
    private LocalDateTime date;

    public Post(Long id, String content, Person author, LocalDateTime date) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
    }

    public Post() {

    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @JsonProperty("author")
    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @JsonProperty("date")
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
