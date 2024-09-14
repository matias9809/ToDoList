package com.mindhub.ToDoList.Service;

import com.mindhub.ToDoList.DTO.PostTaskDto;
import com.mindhub.ToDoList.DTO.TaskDto;
import com.mindhub.ToDoList.DTO.TaskRecepDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    ResponseEntity<List<TaskDto>> getTask();

    ResponseEntity<TaskDto> getTaskById(Long id);

    ResponseEntity<String> addTaskToUser(PostTaskDto taskPostDTO, Long id);

    ResponseEntity<String> deleteTask(Long id);
    ResponseEntity<String> putTask(Long id,TaskRecepDto taskRecepDto);
}
