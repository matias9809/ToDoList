package com.mindhub.ToDoList.Controllers;

import com.mindhub.ToDoList.DTO.PostTaskDto;
import com.mindhub.ToDoList.DTO.TaskDto;
import com.mindhub.ToDoList.DTO.TaskRecepDto;
import com.mindhub.ToDoList.Service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    @Operation(
            summary ="task created",
            description = "created of task information",
            parameters = {

                    @Parameter(
                            name = "taskRecepDto",
                            description ="object that contains information to be created by the task"
                    ),
                    @Parameter(
                            name ="idUser",
                            description = "identifier of the user who is going to be assigned the task"
                    )
            },
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Created")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid created"
                    )
            }
    )
    public ResponseEntity<String> postTask(@RequestBody PostTaskDto taskRecepDto,Long idUser){
        return taskService.addTaskToUser(taskRecepDto,idUser);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary ="task delete",
            description = "delete of task information",
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
                            description = "Invalid delete"
                    )
            }
    )
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
    @PutMapping("/{id}")
    @Operation(
            summary ="task modification",
            description = "modification of task information",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The search query to find matching task",
                            required = false,
                            example = "example search"
                    ),
                    @Parameter(
                            name = "taskRecepDto",
                            description ="object that contains information to be updated by the task",
                            required = false
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
                            description = "Invalid modify"
                    )
            }
    )
    public ResponseEntity<String> putTask(@RequestBody TaskRecepDto taskRecepDto){
        return taskService.putTask(taskRecepDto);
    }
}
