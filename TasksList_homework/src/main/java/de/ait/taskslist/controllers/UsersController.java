package de.ait.taskslist.controllers;

import de.ait.taskslist.controllers.api.UsersApi;
import de.ait.taskslist.dto.*;
import de.ait.taskslist.services.TasksService;
import de.ait.taskslist.services.UsersService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    private final UsersService usersService;
    private final TasksService tasksService;

    @Override
    public ResponseEntity<UserDto> addUser(NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usersService.addUser(newUser));
    }

    @Override
    public ResponseEntity<UsersDto> getAllUsers() {
        return ResponseEntity
                .ok(usersService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long userId) {
        return ResponseEntity
                .ok(usersService.deleteUser(userId));
    }

    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "Пользователь не найден",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "403", description = "Нельзя сделать администратором",
                    content = {
                            @Content()
                    }),
            @ApiResponse(responseCode = "200", description = "Обновленный пользователь",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = UserDto.class))
                    })
    })
    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
        return ResponseEntity
                .ok(usersService.updateUser(userId, updateUser));
    }

    @Override
    public ResponseEntity<UserDto> getUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<TasksDto> getTasksOfUser(Long userId) {
        return ResponseEntity
                .ok(usersService.getTasksOfUser(userId));
    }
    @Override
    public ResponseEntity<TaskDto> addTask(Long userId, NewTaskDto newTask) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(tasksService.addTask(userId, newTask));
    }
}
