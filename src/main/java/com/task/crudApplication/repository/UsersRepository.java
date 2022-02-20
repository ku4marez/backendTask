package com.task.crudApplication.repository;

import com.task.crudApplication.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findUserById(int id);
}
