package com.example.brasilia.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TaskTest {
    /**
     * Method under test: {@link Task#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new Task()).canEqual("Other"));
    }

    /**
     * Method under test: {@link Task#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
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
        assertTrue(task.canEqual(task2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Task#Task()}
     *   <li>{@link Task#setDescription(String)}
     *   <li>{@link Task#setId(Long)}
     *   <li>{@link Task#setStatus(Status)}
     *   <li>{@link Task#setTitle(String)}
     *   <li>{@link Task#setUser(User)}
     *   <li>{@link Task#toString()}
     *   <li>{@link Task#getDescription()}
     *   <li>{@link Task#getId()}
     *   <li>{@link Task#getStatus()}
     *   <li>{@link Task#getTitle()}
     *   <li>{@link Task#getUser()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Task actualTask = new Task();
        actualTask.setDescription("The characteristics of someone or something");
        actualTask.setId(1L);
        actualTask.setStatus(Status.PENDING);
        actualTask.setTitle("Dr");
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        actualTask.setUser(user);
        String actualToStringResult = actualTask.toString();
        String actualDescription = actualTask.getDescription();
        Long actualId = actualTask.getId();
        Status actualStatus = actualTask.getStatus();
        String actualTitle = actualTask.getTitle();
        User actualUser = actualTask.getUser();
        assertEquals("Dr", actualTitle);
        assertEquals("Task(id=1, title=Dr, description=The characteristics of someone or something, status=PENDING,"
                + " user=User(id=1, username=janedoe, tasks=[]))", actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1L, actualId.longValue());
        assertEquals(Status.PENDING, actualStatus);
        assertSame(user, actualUser);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Task#Task(Long, String, String, Status, User)}
     *   <li>{@link Task#setDescription(String)}
     *   <li>{@link Task#setId(Long)}
     *   <li>{@link Task#setStatus(Status)}
     *   <li>{@link Task#setTitle(String)}
     *   <li>{@link Task#setUser(User)}
     *   <li>{@link Task#toString()}
     *   <li>{@link Task#getDescription()}
     *   <li>{@link Task#getId()}
     *   <li>{@link Task#getStatus()}
     *   <li>{@link Task#getTitle()}
     *   <li>{@link Task#getUser()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        Task actualTask = new Task(1L, "Dr", "The characteristics of someone or something", Status.PENDING, user);
        actualTask.setDescription("The characteristics of someone or something");
        actualTask.setId(1L);
        actualTask.setStatus(Status.PENDING);
        actualTask.setTitle("Dr");
        User user2 = new User();
        user2.setId(1L);
        user2.setTasks(new ArrayList<>());
        user2.setUsername("janedoe");
        actualTask.setUser(user2);
        String actualToStringResult = actualTask.toString();
        String actualDescription = actualTask.getDescription();
        Long actualId = actualTask.getId();
        Status actualStatus = actualTask.getStatus();
        String actualTitle = actualTask.getTitle();
        User actualUser = actualTask.getUser();
        assertEquals("Dr", actualTitle);
        assertEquals("Task(id=1, title=Dr, description=The characteristics of someone or something, status=PENDING,"
                + " user=User(id=1, username=janedoe, tasks=[]))", actualToStringResult);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertEquals(1L, actualId.longValue());
        assertEquals(Status.PENDING, actualStatus);
        assertEquals(user, actualUser);
        assertSame(user2, actualUser);
    }

    /**
     * Method under test: {@link Task#equals(Object)}
     */
    @Test
    void testEquals() {
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
        assertNotEquals(task, null);
    }

    /**
     * Method under test: {@link Task#equals(Object)}
     */
    @Test
    void testEquals2() {
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
        assertNotEquals(task, "Different type to Task");
    }
}
