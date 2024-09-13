package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.Task;
import com.mindhub.ToDoList.Enum.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskRecepDto {
    @NotNull@NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private String tittle, description;
    @NotNull@NotBlank
    private TaskStatus taskStatus;

    public TaskRecepDto(Task task) {
        this.tittle = task.getTittle();
        this.description = task.getDescription();
        this.id=task.getId();
        this.taskStatus=task.getTaskStatus();
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
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
}
