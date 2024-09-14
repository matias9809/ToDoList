package com.mindhub.ToDoList.Controllers;



import com.mindhub.ToDoList.DTO.PutUserEntityDto;
import com.mindhub.ToDoList.DTO.UserEntityDto;
import com.mindhub.ToDoList.DTO.UserEntityRecepDto;
import com.mindhub.ToDoList.Service.UserEntityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserEntityController {
    @Autowired
    private UserEntityService userEntityService;

    @GetMapping
    @Operation(
            summary ="get list of user",
            description = "get the list of user information",
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
    public ResponseEntity<List<UserEntityDto>> getListUserEntities(){
        return userEntityService.getUserEntities();
    }
    @GetMapping("/{id}")
    @Operation(
            summary ="get user",
            description = "get of user information",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The search query to find matching user",
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
    public ResponseEntity<UserEntityDto> getUserEntity(@PathVariable Long id){
        return userEntityService.getUserEntityById(id);
    }

    @PostMapping("/post")
    @Operation(
            summary = "Create a user",
            description = "Creates a new user with the provided details",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "User created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(type = "string", example = "Created")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid request"
                    )
            }
    )

    public ResponseEntity<String> addUserEntity(@RequestBody @Valid UserEntityRecepDto userEntity){
        System.out.println(userEntity.toString());
        return userEntityService.postUserEntity(userEntity);
    }
    @PutMapping("/{id}")
    @Operation(
            summary ="user modification",
            description = "modification of user information",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The search query to find matching user",
                            required = false,
                            example = "example search"
                    )
            },requestBody = @RequestBody(
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = PutUserEntityDto.class)
                    )
            ),
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
    public ResponseEntity<String> putUserEntity(@PathVariable Long id,@RequestBody PutUserEntityDto userEntityDto){
        return userEntityService.putUsertEntity(id,userEntityDto);

    }
    @DeleteMapping("/{id}")
    @Operation(
            summary ="user delete",
            description = "delete of user information",
            parameters = {
                    @Parameter(
                            name = "id",
                            description = "The search query to find matching user",
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
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return  userEntityService.deleteUserEntity(id);
    }
}