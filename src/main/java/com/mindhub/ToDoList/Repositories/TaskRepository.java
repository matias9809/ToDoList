package com.mindhub.ToDoList.Repositories;

import com.mindhub.ToDoList.Entitys.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
