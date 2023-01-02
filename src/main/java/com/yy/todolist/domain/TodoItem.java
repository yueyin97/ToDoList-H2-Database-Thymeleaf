package com.yy.todolist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// @Entity: marks a class as a persistent entity and should be mapped to a database table, and its fields should be mapped to columns in that table.
// @Id: marks a field in a persistent entity as the primary key for that entity
// @GeneratedValue: specifies that the value of a persistent entity's primary key should be generated automatically by the database when a new entity is persisted

@Entity
public class TodoItem {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private boolean completed; // flag

    public TodoItem() {
    }

    public TodoItem(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", completed=" + completed +
                '}';
    }
}