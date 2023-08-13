package de.ait.taskslist.services;

import de.ait.taskslist.dto.NewTaskDto;
import de.ait.taskslist.dto.TaskDto;

public interface TasksService {
    TaskDto addTask(Long userId, NewTaskDto newTask);
}
