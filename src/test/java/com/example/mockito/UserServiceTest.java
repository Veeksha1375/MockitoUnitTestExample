package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test
    public void testGetUserName() {
        // Arrange
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockUserRepository);
        User user = new User(1, "John Doe");

        when(mockUserRepository.findById(1)).thenReturn(user);

        // Act
        String result = userService.getUserName(1);

        // Assert
        assertEquals("John Doe", result);
    }

    @Test
    public void testGetUserName_UserNotFound() {
        // Arrange
        UserRepository mockUserRepository = mock(UserRepository.class);
        UserService userService = new UserService(mockUserRepository);

        when(mockUserRepository.findById(2)).thenReturn(null);

        // Act
        String result = userService.getUserName(2);

        // Assert
        assertEquals("User not found", result);
    }
}