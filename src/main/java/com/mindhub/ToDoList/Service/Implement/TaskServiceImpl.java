package com.mindhub.ToDoList.Service.Implement;

import com.mindhub.ToDoList.DTO.PostTaskDto;
import com.mindhub.ToDoList.DTO.TaskDto;
import com.mindhub.ToDoList.DTO.TaskRecepDto;
import com.mindhub.ToDoList.Entitys.Task;
import com.mindhub.ToDoList.Entitys.UserEntity;
import com.mindhub.ToDoList.Repositories.TaskRepository;
import com.mindhub.ToDoList.Repositories.UserEntityRepository;
import com.mindhub.ToDoList.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Override
    public ResponseEntity<List<TaskDto>> getTask() {
        return new ResponseEntity<>
                (taskRepository.findAll().stream().map(TaskDto::new)
                        .collect(Collectors.toList()),HttpStatus.OK);

    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(Long id) {
        Task task=taskRepository.findById(id).orElse(null);
        if (task==null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new TaskDto(task),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addTaskToUser(PostTaskDto taskRecepDto, Long id) {
        UserEntity userEntity=userEntityRepository.findById(id).orElse(null);
        if (userEntity==null){
            return new ResponseEntity<>("The user to be assigned " +
                    "to the task was not found",HttpStatus.BAD_REQUEST);
        }
        if (taskRecepDto.getTittle().isEmpty()){
            return  new ResponseEntity<>("the title cannot be empty"
                    , HttpStatus.BAD_REQUEST);
        }
        Task task=new Task(taskRecepDto);
        userEntity.addTask(task);
        userEntityRepository.save(userEntity);
        taskRepository.save(task);
        return new ResponseEntity<>("the task was created and " +
                "assigned correctly",HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<String> deleteTask(Long id) {
        Task task=taskRepository.findById(id).orElse(null);
        if (task==null){
            return new ResponseEntity<>("The task not found",
                    HttpStatus.BAD_REQUEST);
        }
        taskRepository.delete(task);
        return new ResponseEntity<>("The task was successfully deleted",
                HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> putTask( Long id,TaskRecepDto taskRecepDto) {
        Task task=taskRepository.findById(id).orElse(null);
        if (task==null){
            return new ResponseEntity<>("The task not found",
                    HttpStatus.BAD_REQUEST);
        }

        task.setTaskStatus(taskRecepDto.getTaskStatus());
        task.setDescription(taskRecepDto.getDescription());
        task.setTittle(taskRecepDto.getTittle());
        taskRepository.save(task);
        return new ResponseEntity<>("modification correctly",
                HttpStatus.OK);
    }
}
