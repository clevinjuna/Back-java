package fr.mns.java.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.mns.java.rest.dto.PostDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="content", length=2047)
    private String content;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Person author;

    @Column(name = "date")
    private LocalDateTime date;

    @ManyToOne
    private Post post;


    public Comment(Long id, String content, Person author, LocalDateTime date, Post post) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.date = date;
        this.post = post;
    }

    public Comment() {}

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

    @JsonProperty("post")
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
