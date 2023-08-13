//package de.ait.taskslist.controllers.api;
//
//import de.ait.taskslist.dto.NewTaskDto;
//import de.ait.taskslist.dto.TaskDto;
//import de.ait.taskslist.dto.TasksDto;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import io.swagger.v3.oas.annotations.tags.Tags;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@Tags(value = {
//        @Tag(name = "Tasks")
//})
//@RequestMapping("/tasks")
//public interface TasksApi {
//
//    @Operation(summary = "Создание задачи для пользователя", description = "Доступно всем пользователям")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "422", description = "Пользователь с указанным ID отсутствует в системе",
//                    content = {
//                            @Content()
//                    }),
//            @ApiResponse(responseCode = "201", description = "Добавленная задача",
//                    content = {
//                            @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
//                    })
//    })
//    @PostMapping("/{user-id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    ResponseEntity<TaskDto> addTask(@Parameter(required = true, description = "Идентификатор пользователя", example = "2")
//                                    @PathVariable("user-id") Long userId,
//                                    @RequestBody NewTaskDto newTask);
//}