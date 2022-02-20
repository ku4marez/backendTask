package com.task.crudApplication.service;

import com.task.crudApplication.Dto.UserDto;
import com.task.crudApplication.entity.User;
import com.task.crudApplication.exception.UserNotFoundException;
import com.task.crudApplication.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> findAll() {
        log.info("Looking for all users");
        return usersRepository.findAll();
    }

    public void deleteUser(int id) throws UserNotFoundException {
        log.info("Deleting user with the id: " + id);
        User existingUser = usersRepository.findUserById(id);
        if (existingUser != null) {
            usersRepository.deleteById(id);
        } else throw new UserNotFoundException("User was not found");
    }

    public void updateExistingUser(int id, UserDto updatedUser)
            throws UserNotFoundException {
        User existingUser = usersRepository.findUserById(id);
        if (existingUser != null) {
            log.info("Updating user with the id: " + id);
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            usersRepository.save(existingUser);
        } else throw new UserNotFoundException("User was not found");
    }

    public void saveNewUser(User user) {
        log.info("Creating new user");
        usersRepository.save(user);
    }
}
