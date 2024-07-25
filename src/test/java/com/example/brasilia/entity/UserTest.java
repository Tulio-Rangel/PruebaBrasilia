package com.example.brasilia.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Method under test: {@link User#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new User()).canEqual("Other"));
    }

    /**
     * Method under test: {@link User#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");

        User user2 = new User();
        user2.setId(1L);
        user2.setTasks(new ArrayList<>());
        user2.setUsername("janedoe");
        assertTrue(user.canEqual(user2));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setTasks(List)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getTasks()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setId(1L);
        ArrayList<Task> tasks = new ArrayList<>();
        actualUser.setTasks(tasks);
        actualUser.setUsername("janedoe");
        String actualToStringResult = actualUser.toString();
        Long actualId = actualUser.getId();
        List<Task> actualTasks = actualUser.getTasks();
        assertEquals("User(id=1, username=janedoe, tasks=[])", actualToStringResult);
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(1L, actualId.longValue());
        assertSame(tasks, actualTasks);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#User(Long, String, List)}
     *   <li>{@link User#setId(Long)}
     *   <li>{@link User#setTasks(List)}
     *   <li>{@link User#setUsername(String)}
     *   <li>{@link User#toString()}
     *   <li>{@link User#getId()}
     *   <li>{@link User#getTasks()}
     *   <li>{@link User#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        ArrayList<Task> tasks = new ArrayList<>();
        User actualUser = new User(1L, "janedoe", tasks);
        actualUser.setId(1L);
        ArrayList<Task> tasks2 = new ArrayList<>();
        actualUser.setTasks(tasks2);
        actualUser.setUsername("janedoe");
        String actualToStringResult = actualUser.toString();
        Long actualId = actualUser.getId();
        List<Task> actualTasks = actualUser.getTasks();
        assertEquals("User(id=1, username=janedoe, tasks=[])", actualToStringResult);
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals(1L, actualId.longValue());
        assertEquals(tasks, actualTasks);
        assertSame(tasks2, actualTasks);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        assertNotEquals(user, null);
    }

    /**
     * Method under test: {@link User#equals(Object)}
     */
    @Test
    void testEquals2() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        assertNotEquals(user, "Different type to User");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link User#equals(Object)}
     *   <li>{@link User#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        assertEquals(user, user);
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

}
