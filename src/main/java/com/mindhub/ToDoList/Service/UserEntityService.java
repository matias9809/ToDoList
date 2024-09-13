package com.mindhub.ToDoList.Service;
import com.mindhub.ToDoList.DTO.PutUserEntityDto;
import com.mindhub.ToDoList.DTO.UserEntityDto;
import com.mindhub.ToDoList.DTO.UserEntityRecepDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserEntityService {
     ResponseEntity<List<UserEntityDto>> getUserEntities();

     ResponseEntity<UserEntityDto> getUserEntityById(Long id);

     ResponseEntity<String> postUserEntity(UserEntityRecepDto userEntityPostDTO, String password);

     ResponseEntity<String> deleteUserEntity(Long id);

     ResponseEntity<String> putUsertEntity(Long id, PutUserEntityDto userEntityRecepDto);

}
