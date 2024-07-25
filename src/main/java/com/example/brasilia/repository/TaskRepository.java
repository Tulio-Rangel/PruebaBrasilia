package com.example.brasilia.repository;

import com.example.brasilia.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Obtener todas las tareas de un usuario por el ID del usuario
    List<Task> findTasksByUserId(Long userId);

    // Obtener una tarea específica de un usuario por ID de tarea y usuario
    Optional<Task> findByIdAndUserId(Long taskId, Long userId);
}
