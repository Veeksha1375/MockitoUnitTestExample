package com.example.mockito;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int userId) {
        User user = userRepository.findById(userId);
        return user != null ? user.getName() : "User not found";
    }
}