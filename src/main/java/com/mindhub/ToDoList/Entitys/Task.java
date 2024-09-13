package com.mindhub.ToDoList.Entitys;

import com.mindhub.ToDoList.DTO.PostTaskDto;
import com.mindhub.ToDoList.DTO.TaskRecepDto;
import com.mindhub.ToDoList.Enum.TaskStatus;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tittle,description;
    private TaskStatus taskStatus=TaskStatus.PENDING;
    @ManyToOne
    private UserEntity user;

    public Task(String title, String description) {
        this.tittle = title;
        this.description = description;
    }
    public Task(PostTaskDto taskRecepDto) {
        this.tittle = taskRecepDto.getTittle();
        this.description = taskRecepDto.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
