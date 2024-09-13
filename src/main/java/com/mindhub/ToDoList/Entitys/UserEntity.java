package com.mindhub.ToDoList.Entitys;

import com.mindhub.ToDoList.DTO.UserEntityRecepDto;
import jakarta.persistence.*;
import jogamp.common.os.elf.SectionArmAttributes;
import org.apache.catalina.User;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName,password,email;
    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.REMOVE)
    private Set<Task> tasks=new HashSet<Task>();

    public UserEntity(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
    public UserEntity(UserEntityRecepDto userEntityRecepDto){
        this.userName = userEntityRecepDto.getUserName();
        this.password = userEntityRecepDto.getPassword();
        this.email = userEntityRecepDto.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
    public void addTask(Task task){
        task.setUser(this);
        tasks.add(task);
    }
}
