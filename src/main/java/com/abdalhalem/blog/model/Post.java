package com.abdalhalem.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    private String imageFileName;

    protected Post() {
    }

    public Post(String title, String content, String imageFileName) {
        this.title = title;
        this.content = content;
        this.imageFileName = imageFileName;
    }

    @Override
    public String toString() {
        return String.format(
                "blog[id=%d, title='%s', content='%s', image='%s']",
                id, title, content, imageFileName);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }
}