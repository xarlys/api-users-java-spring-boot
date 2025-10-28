package com.example.modules.users.services;

import com.example.modules.users.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    
    private List<User> users;
    
    public UserServiceImpl() {
        users = new ArrayList<>();
        users.add(new User(1L, "Xarlys 1", "xarlysouza@hotmail.com"));
        users.add(new User(2L, "Xarlys 2", "xarlysouza@hotmail.com"));
        users.add(new User(3L, "Xarlys 3", "xarlysouza@hotmail.com"));
    }
    
    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    
    @Override
    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
    
    @Override
    public User createUser(User user) {
        users.add(user);
        return user;
    }
    
    @Override
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = getUserById(id);
        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();
            userToUpdate.setName(user.getName());
            userToUpdate.setEmail(user.getEmail());
            return userToUpdate;
        }
        return null;
    }
    
    @Override
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}