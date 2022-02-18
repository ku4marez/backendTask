package com.task1.task1.repository;

import com.task1.task1.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    List<Users> findAll();

    Users findUserById(Long id);
}
