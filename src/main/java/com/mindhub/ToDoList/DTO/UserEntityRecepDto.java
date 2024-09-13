package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.UserEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserEntityRecepDto {
    @NotBlank@NotNull@NotBlank
    private String userName,password;
    @NotNull
    @NotBlank
    @Email
    private String email;

    public UserEntityRecepDto(String password, UserEntity userEntity){
        this.email=userEntity.getEmail();
        this.userName=userEntity.getUserName();
        this.password=password;
    }

    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

}
