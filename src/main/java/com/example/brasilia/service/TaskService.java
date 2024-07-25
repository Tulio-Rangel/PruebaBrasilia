package com.example.brasilia.service;

import com.example.brasilia.entity.Status;
import com.example.brasilia.entity.Task;
import com.example.brasilia.entity.User;
import com.example.brasilia.repository.TaskRepository;
import com.example.brasilia.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    // Crear una nueva tarea para un usuario específico
    @Transactional
    public Task createTask(Long userId, Task task) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            task.setStatus(Status.PENDING);
            task.setUser(user);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
    }

    // Obtener la lista de todas las tareas de un usuario
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findTasksByUserId(userId);
    }

    // Marcar una tarea como completada para un usuario específico
    @Transactional
    public Task markTaskAsCompleted(Long userId, Long taskId) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUserId(taskId, userId);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setStatus(Status.COMPLETED);
            return taskRepository.save(task);
        } else {
            throw new IllegalArgumentException("Tarea no encontrada o no pertenece al usuario");
        }
    }

    // Eliminar una tarea para un usuario específico
    @Transactional
    public void deleteTask(Long userId, Long taskId) {
        Optional<Task> taskOptional = taskRepository.findByIdAndUserId(taskId, userId);
        if (taskOptional.isPresent()) {
            taskRepository.delete(taskOptional.get());
        } else {
            throw new IllegalArgumentException("Tarea no encontrada o no pertenece al usuario");
        }
    }
}
