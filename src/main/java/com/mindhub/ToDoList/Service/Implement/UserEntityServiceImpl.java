package com.mindhub.ToDoList.Service.Implement;

import com.mindhub.ToDoList.DTO.PutUserEntityDto;
import com.mindhub.ToDoList.DTO.TaskDto;
import com.mindhub.ToDoList.DTO.UserEntityDto;
import com.mindhub.ToDoList.DTO.UserEntityRecepDto;
import com.mindhub.ToDoList.Entitys.UserEntity;
import com.mindhub.ToDoList.Repositories.TaskRepository;
import com.mindhub.ToDoList.Repositories.UserEntityRepository;
import com.mindhub.ToDoList.Service.TaskService;
import com.mindhub.ToDoList.Service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mindhub.ToDoList.Utils.PasswordChecker.isValidPassword;
@Service
public class UserEntityServiceImpl implements UserEntityService {
    @Autowired
    private UserEntityRepository userEntityRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public ResponseEntity<List<UserEntityDto>> getUserEntities() {
        return new ResponseEntity<>(userEntityRepository.findAll().stream().map(UserEntityDto::new).toList(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntityDto> getUserEntityById(Long id) {
        UserEntity userEntity=userEntityRepository.findById(id).orElse(null);
        if (userEntity==null){
            return null;
        }

        return new ResponseEntity<>(new UserEntityDto(userEntity),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> postUserEntity(UserEntityRecepDto userEntityPostDTO) {
        if (userEntityPostDTO.getUserName()==null){
            return new ResponseEntity<>("the name cannot be null",HttpStatus.BAD_REQUEST);
        }
        if (userEntityPostDTO.getUserName().isEmpty()){
            return new ResponseEntity<>("the name cannot be empty",HttpStatus.BAD_REQUEST);
        }

        if (userEntityPostDTO.getEmail().isEmpty()){
            return new ResponseEntity<>("the email cannot be empty",HttpStatus.BAD_REQUEST);
        }
        if (userEntityPostDTO.getPassword().isEmpty()){
            return new ResponseEntity<>("the password cannot be empty",HttpStatus.BAD_REQUEST);
        }
        if (isValidPassword(userEntityPostDTO.getPassword())){
            return new ResponseEntity<>("The password must be 8 or more characters, at least 1 uppercase, 1 lowercase and 1 special character",HttpStatus.OK);
        }
        UserEntity userEntity=new UserEntity(userEntityPostDTO);
        userEntityRepository.save(userEntity);

        return new ResponseEntity<>("the user was successfully registered",HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteUserEntity(Long id) {
        if (!userEntityRepository.existsById(id)){
            return new ResponseEntity<>("The user to be assigned to the task was not found",HttpStatus.BAD_REQUEST);
        }
        userEntityRepository.deleteById(id);
        return new ResponseEntity<>("the user was successfully deleted",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> putUsertEntity(Long id, PutUserEntityDto userEntityRecepDto) {
        UserEntity userEntity=userEntityRepository.findById(id).orElse(null);
        if (userEntity==null){
            return new ResponseEntity<>("The user to be assigned to the task was not found",HttpStatus.BAD_REQUEST);
        }
        userEntity.setEmail(userEntityRecepDto.getEmail());
        userEntity.setUserName(userEntityRecepDto.getUserName());
        userEntityRepository.save(userEntity);
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }
}
