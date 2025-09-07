package com.app.ToDoApp.Controller;


import com.app.ToDoApp.Service.TaskService;
import com.app.ToDoApp.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskservice;

    public TaskController(TaskService taskservice) {
        this.taskservice = taskservice;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks=taskservice.getalltasks();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(@RequestParam String title){
        taskservice.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id ){
        taskservice.deletetask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String tasktoggle(@PathVariable Long id){
        taskservice.tasktoggle(id);
        return "redirect:/";
    }
}
