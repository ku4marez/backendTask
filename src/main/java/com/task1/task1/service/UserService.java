package com.task1.task1.service;

import com.task1.task1.Dto.UserDto;
import com.task1.task1.entity.Users;
import com.task1.task1.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public void updateExistingUser(Long id, UserDto updatedUser) {
        Users existingUser = usersRepository.findUserById(id);
        if (existingUser != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setSecondName(updatedUser.getSecondName());
            usersRepository.save(existingUser);
        } else throw new RuntimeException("User was not found");
    }

    public Users saveNewUser(Users user) {
        return usersRepository.save(user);
    }
}
