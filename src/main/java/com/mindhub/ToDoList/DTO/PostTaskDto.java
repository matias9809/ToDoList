package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.Task;
import com.mindhub.ToDoList.Enum.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostTaskDto {
    @NotNull
    @NotBlank
    private String tittle, description;

    public PostTaskDto(Task task) {
        this.tittle = task.getTittle();
        this.description = task.getDescription();
    }
    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }
}
