package com.example.brasilia.controller;

import com.example.brasilia.entity.Task;
import com.example.brasilia.entity.User;
import com.example.brasilia.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    // Crear una nueva tarea para un usuario específico
    @PostMapping("/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Long userId, @RequestBody Task task) {
        Task response = taskService.createTask(userId, task);
        HttpStatus status = null;
        try {
            if (response != null) {
                status = HttpStatus.CREATED;
                return ResponseEntity.status(status).body(response);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Obtener la lista de todas las tareas de un usuario
    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        List<Task> tasks = taskService.getTasksByUserId(userId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // Marcar una tarea como completada para un usuario específico
    @PutMapping("/{userId}/{taskId}/complete")
    public ResponseEntity<Task> markTaskAsCompleted(@PathVariable Long userId, @PathVariable Long taskId) {
        try {
            Task updatedTask = taskService.markTaskAsCompleted(userId, taskId);
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una tarea para un usuario específico
    @DeleteMapping("/{userId}/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long userId, @PathVariable Long taskId) {
        try {
            taskService.deleteTask(userId, taskId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
