package com.codegym.blog_application.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String topic;
    @Column(columnDefinition = "text")
    private String content;
    private String writer;
    @Column(name = "date_submitted")
    private Date dateSubmitted;

    public Blog() {
    }

    public Blog(String topic, String content, String writer, Date dateSubmitted) {
        this.topic = topic;
        this.content = content;
        this.writer = writer;
        this.dateSubmitted = dateSubmitted;
    }

    public Blog(int id, String topic, String content, String writer, Date dateSubmitted) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.writer = writer;
        this.dateSubmitted = dateSubmitted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }
}
