package com.app.ToDoApp.Service;

import com.app.ToDoApp.Repository.TaskRepository;
import com.app.ToDoApp.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskrepository;

    public TaskService(TaskRepository taskrepository) {
        this.taskrepository = taskrepository;
    }

    public List<Task> getalltasks() {
       return taskrepository.findAll();

    }

    public void createTask(String title) {
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskrepository.save(task);
    }

    public void deletetask(Long id) {
        taskrepository.deleteById(id);
    }

    public void tasktoggle(Long id) {
        Task task=taskrepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskrepository.save(task);
    }
}
