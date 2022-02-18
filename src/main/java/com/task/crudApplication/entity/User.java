package com.task.crudApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import static com.task.crudApplication.constant.Constants.maxSize;
import static com.task.crudApplication.constant.Constants.minSize;


@Entity
@Table(schema = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(min = minSize, max = maxSize)
    private String firstName;
    @Size(min = minSize, max = maxSize)
    private String lastName;
    @Positive
    private int age;
}
