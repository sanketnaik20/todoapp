package com.app.todoapp.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.app.todoapp.models.Task;
import com.app.todoapp.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepo) {
        taskRepository = taskRepo;
    }


    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
      Task task=new Task();
      task.setTitle(title);
      task.setCompleted(false);
      taskRepository.save(task);
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }


    public void toggleTask(Long id) {
       Task task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("invalid task id"));

        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);

    }
    
}