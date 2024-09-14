package com.mindhub.ToDoList.Controllers;

import com.mindhub.ToDoList.DTO.PostTaskDto;
import com.mindhub.ToDoList.DTO.TaskDto;
import com.mindhub.ToDoList.DTO.TaskRecepDto;
import com.mindhub.ToDoList.Service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(
            summary ="get list of task",
            description = "get the list of task information",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Ok")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request"
                    )
            }
    )
    public ResponseEntity<List<TaskDto>> getListTask(){
        return taskService.getTask();
    }
    @GetMapping("/{id}")
    @Operation(
            summary ="get task",
            description = "get of task information",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The search query to find matching task",
                            required = false,
                            example = "example search"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Ok")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid search"
                    )
            }
    )
    public ResponseEntity<TaskDto> getTaskId(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    @PostMapping
    public ResponseEntity<String> postTask(@RequestBody PostTaskDto taskRecepDto, @RequestParam Long idUser){
        return taskService.addTaskToUser(taskRecepDto,idUser);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary ="task delete",
            description = "delete of task information",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Ok")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid delete"
                    )
            }
    )
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> putTask(@PathVariable Long id,@RequestBody TaskRecepDto taskRecepDto){
        return taskService.putTask(id,taskRecepDto);
    }
}
