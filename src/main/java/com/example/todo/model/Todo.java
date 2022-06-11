package com.example.todo.model;

import javax.persistence.*;

@Entity
@Table
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    @Column(name = "is_visible")
    private boolean isVisible;

    public Todo(Integer id, String title, String content, boolean isVisible) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isVisible = isVisible;
    }

    public Todo(String title, String content, boolean isVisible) {
        this.title = title;
        this.content = content;
        this.isVisible = isVisible;
    }

    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isVisible=" + isVisible +
                '}';
    }
}
