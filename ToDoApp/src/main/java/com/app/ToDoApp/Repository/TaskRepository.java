package com.app.ToDoApp.Repository;

import com.app.ToDoApp.model.Task;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
