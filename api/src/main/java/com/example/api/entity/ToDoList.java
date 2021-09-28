package com.example.api.entity;

import javax.persistence.*;

@Entity
@Table(name = "todoList")
public class ToDoList {

    private long id;

    private String taskName;
    private String description;

    public ToDoList() {
    }

    public ToDoList(String taskName, String description) {
        this.taskName = taskName;
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "task_name", nullable = false)
    public String getTaskName() {return taskName;}
    public void setTaskName(String taskName) { this.taskName = taskName; }

    @Column(name = "description", nullable = false)
    public String getDescription() {return description;}
    public void setDescription(String description) { this.description = description; }
}
