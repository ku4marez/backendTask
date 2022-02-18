package com.task.crudApplication.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class UserDto {
    @Size(min = 2, max = 10)
    private String firstName;
    @Size(min = 2, max = 10)
    private String lastName;
}
