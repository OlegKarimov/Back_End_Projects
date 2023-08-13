//package de.ait.taskslist.controllers;
//
//import de.ait.taskslist.controllers.api.TasksApi;
//import de.ait.taskslist.dto.NewTaskDto;
//import de.ait.taskslist.dto.TaskDto;
//import de.ait.taskslist.services.TasksService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//public class TasksController implements TasksApi {
//    private final TasksService tasksService;
//    @Override
//    public ResponseEntity<TaskDto> addTask(Long userId, NewTaskDto newTask) {
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(tasksService.addTask(userId, newTask));
//    }
//}
