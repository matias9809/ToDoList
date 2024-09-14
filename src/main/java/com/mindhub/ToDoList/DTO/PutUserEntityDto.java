package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PutUserEntityDto {
    @NotBlank@NotNull
    private String userName;
    @NotNull
    @NotBlank
    @Email
    private String email;

    public PutUserEntityDto(String userName,String email){
        this.email=email;
        this.userName=userName;
    }

    public PutUserEntityDto() {
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

}
