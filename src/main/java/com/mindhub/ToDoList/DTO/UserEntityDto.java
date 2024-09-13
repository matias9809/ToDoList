package com.mindhub.ToDoList.DTO;

import com.mindhub.ToDoList.Entitys.UserEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class UserEntityDto {
    private  Long id;
    private  String userName,email;
    private Set<TaskDto> taskDtos=new HashSet<>();

    public UserEntityDto(UserEntity userEntity){
        this.id=userEntity.getId();
        this.userName=userEntity.getUserName();
        this.email=userEntity.getEmail();
        this.taskDtos=userEntity.getTasks().stream().map(TaskDto::new).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Set<TaskDto> getTaskDtos() {
        return taskDtos;
    }
}
