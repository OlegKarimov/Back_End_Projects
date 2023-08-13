package de.ait.taskslist.services;

import de.ait.taskslist.dto.*;

public interface UsersService {
    UserDto addUser(NewUserDto newUser);

    UsersDto getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser(Long userId, UpdateUserDto updateUser);

    UserDto getUser(Long userId);

    TasksDto getTasksOfUser(Long userId);
}
