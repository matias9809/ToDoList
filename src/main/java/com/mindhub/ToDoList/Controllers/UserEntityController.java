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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping()
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

    @PostMapping
    @Operation(
            summary ="user created",
            description = "created of user information",
            parameters = {

                    @Parameter(
                            name = "userEntityDto",
                            description ="object that contains information to be created by the user"
                    ),
                    @Parameter(
                    name = "password",
                    description = "contains the user's password"
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
    public ResponseEntity<String> addUserEntity(@RequestBody UserEntityRecepDto userEntity, String password){
        return userEntityService.postUserEntity(userEntity,password);
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
                    ),
                    @Parameter(
                      name = "userEntityDto",
                      description ="object that contains information to be updated by the user",
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
