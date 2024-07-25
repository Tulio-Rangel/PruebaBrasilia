package com.example.brasilia.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.brasilia.entity.User;
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

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#createUser(User)}
     */
    @Test
    void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        when(userRepository.save(Mockito.<User>any())).thenReturn(user);

        User user2 = new User();
        user2.setId(1L);
        user2.setTasks(new ArrayList<>());
        user2.setUsername("janedoe");
        User actualCreateUserResult = userService.createUser(user2);
        verify(userRepository).save(Mockito.<User>any());
        assertSame(user, actualCreateUserResult);
    }

    /**
     * Method under test: {@link UserService#getAllUsers()}
     */
    @Test
    void testGetAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList);
        List<User> actualAllUsers = userService.getAllUsers();
        verify(userRepository).findAll();
        assertTrue(actualAllUsers.isEmpty());
        assertSame(userList, actualAllUsers);
    }

    /**
     * Method under test: {@link UserService#getUserById(Long)}
     */
    @Test
    void testGetUserById() {
        User user = new User();
        user.setId(1L);
        user.setTasks(new ArrayList<>());
        user.setUsername("janedoe");
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<User> actualUserById = userService.getUserById(1L);
        verify(userRepository).findById(Mockito.<Long>any());
        assertTrue(actualUserById.isPresent());
        assertSame(ofResult, actualUserById);
    }
}
