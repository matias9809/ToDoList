package com.mindhub.ToDoList.Repositories;

import com.mindhub.ToDoList.Entitys.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Long> {
}
