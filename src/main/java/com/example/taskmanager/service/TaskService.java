package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.exception.TaskNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private int currentId = 1;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        task.setId(currentId++);
        tasks.add(task);
        return task;
    }

    public String deleteTask(int id) {
        Task task = tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found."));
        tasks.remove(task);
        return "Task deleted successfully!";
    }
}
