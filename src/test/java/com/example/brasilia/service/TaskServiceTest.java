package com.example.brasilia.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.brasilia.entity.Status;
import com.example.brasilia.entity.Task;
import com.example.brasilia.entity.User;
import com.example.brasilia.repository.TaskRepository;
import com.example.brasilia.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TaskService.class})
@ExtendWith(SpringExtension.class)
class TaskServiceTest {
    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @MockBean
    private UserRepository userRepository;

    /**
     * Method under test: {@link TaskService#createTask(Long, String, String)}
     */
    @Test
    void testCreateTask() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        Task task = new Task();
        task.setDescription("The characteristics of someone or something");
        task.setId(1L);
        task.setStatus(Status.PENDING);
        task.setTitle("Dr");
        task.setUser(user);
        when(taskRepository.save(Mockito.<Task>any())).thenReturn(task);

        User user2 = new User();
        user2.setId(1L);
        user2.setTasks(new ArrayList<>());
        user2.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user2);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Task actualCreateTaskResult = taskService.createTask(1L, "Dr", "The characteristics of someone or something");
        verify(userRepository).findById(Mockito.<Long>any());
        verify(taskRepository).save(Mockito.<Task>any());
        assertSame(task, actualCreateTaskResult);
    }

    /**
     * Method under test:  {@link TaskService#createTask(Long, String, String)}
     */
    @Test
    void testCreateTask2() {
        when(taskRepository.save(Mockito.<Task>any())).thenThrow(new IllegalArgumentException("foo"));

        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class,
                () -> taskService.createTask(1L, "Dr", "The characteristics of someone or something"));
        verify(userRepository).findById(Mockito.<Long>any());
        verify(taskRepository).save(Mockito.<Task>any());
    }


    /**
     * Method under test: {@link TaskService#getTasksByUserId(Long)}
     */
    @Test
    void testGetTasksByUserId() {
        ArrayList<Task> taskList = new ArrayList<>();
        when(taskRepository.findTasksByUserId(Mockito.<Long>any())).thenReturn(taskList);
        List<Task> actualTasksByUserId = taskService.getTasksByUserId(1L);
        verify(taskRepository).findTasksByUserId(Mockito.<Long>any());
        assertTrue(actualTasksByUserId.isEmpty());
        assertSame(taskList, actualTasksByUserId);
    }

    /**
     * Method under test:  {@link TaskService#getTasksByUserId(Long)}
     */
    @Test
    void testGetTasksByUserId2() {
        when(taskRepository.findTasksByUserId(Mockito.<Long>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> taskService.getTasksByUserId(1L));
        verify(taskRepository).findTasksByUserId(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link TaskService#markTaskAsCompleted(Long, Long)}
     */
    @Test
    void testMarkTaskAsCompleted() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        Task task = new Task();
        task.setDescription("The characteristics of someone or something");
        task.setId(1L);
        task.setStatus(Status.PENDING);
        task.setTitle("Dr");
        task.setUser(user);
        Optional<Task> ofResult = Optional.of(task);

        User user2 = new User();
        user2.setId(1L);
        user2.setTasks(new ArrayList<>());
        user2.setUsername("janedoe");

        Task task2 = new Task();
        task2.setDescription("The characteristics of someone or something");
        task2.setId(1L);
        task2.setStatus(Status.PENDING);
        task2.setTitle("Dr");
        task2.setUser(user2);
        when(taskRepository.save(Mockito.<Task>any())).thenReturn(task2);
        when(taskRepository.findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(ofResult);
        Task actualMarkTaskAsCompletedResult = taskService.markTaskAsCompleted(1L, 1L);
        verify(taskRepository).findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any());
        verify(taskRepository).save(Mockito.<Task>any());
        assertSame(task2, actualMarkTaskAsCompletedResult);
    }

    /**
     * Method under test: {@link TaskService#markTaskAsCompleted(Long, Long)}
     */
    @Test
    void testMarkTaskAsCompleted2() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        Task task = new Task();
        task.setDescription("The characteristics of someone or something");
        task.setId(1L);
        task.setStatus(Status.PENDING);
        task.setTitle("Dr");
        task.setUser(user);
        Optional<Task> ofResult = Optional.of(task);
        when(taskRepository.save(Mockito.<Task>any())).thenThrow(new IllegalArgumentException("foo"));
        when(taskRepository.findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> taskService.markTaskAsCompleted(1L, 1L));
        verify(taskRepository).findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any());
        verify(taskRepository).save(Mockito.<Task>any());
    }

    /**
     * Method under test: {@link TaskService#deleteTask(Long, Long)}
     */
    @Test
    void testDeleteTask() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        Task task = new Task();
        task.setDescription("The characteristics of someone or something");
        task.setId(1L);
        task.setStatus(Status.PENDING);
        task.setTitle("Dr");
        task.setUser(user);
        Optional<Task> ofResult = Optional.of(task);
        doNothing().when(taskRepository).delete(Mockito.<Task>any());
        when(taskRepository.findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(ofResult);
        taskService.deleteTask(1L, 1L);
        verify(taskRepository).findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any());
        verify(taskRepository).delete(Mockito.<Task>any());
    }

    /**
     * Method under test: {@link TaskService#deleteTask(Long, Long)}
     */
    @Test
    void testDeleteTask2() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        Task task = new Task();
        task.setDescription("The characteristics of someone or something");
        task.setId(1L);
        task.setStatus(Status.PENDING);
        task.setTitle("Dr");
        task.setUser(user);
        Optional<Task> ofResult = Optional.of(task);
        doThrow(new IllegalArgumentException("foo")).when(taskRepository).delete(Mockito.<Task>any());
        when(taskRepository.findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> taskService.deleteTask(1L, 1L));
        verify(taskRepository).findByIdAndUserId(Mockito.<Long>any(), Mockito.<Long>any());
        verify(taskRepository).delete(Mockito.<Task>any());
    }

}
