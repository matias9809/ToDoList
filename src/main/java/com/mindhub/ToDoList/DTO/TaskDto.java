package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.Task;
import com.mindhub.ToDoList.Enum.TaskStatus;

public class TaskDto {
    private Long id;
    private String tittle, description;
    private TaskStatus taskStatus;

    public TaskDto(Task task){
        this.id = task.getId();
        this.tittle = task.getTittle();
        this.description = task.getDescription();
        this.taskStatus = task.getTaskStatus();
        this.id = task.getId();
    }

    public Long getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
