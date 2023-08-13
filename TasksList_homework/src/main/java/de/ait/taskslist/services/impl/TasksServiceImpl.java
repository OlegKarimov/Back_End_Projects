package de.ait.taskslist.services.impl;
import de.ait.taskslist.dto.NewTaskDto;
import de.ait.taskslist.dto.TaskDto;
import de.ait.taskslist.exceptions.NotFoundException;
import de.ait.taskslist.models.Task;
import de.ait.taskslist.repositories.TasksRepository;
import de.ait.taskslist.services.TasksService;
import de.ait.taskslist.models.User;
import de.ait.taskslist.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import static de.ait.taskslist.dto.TaskDto.from;


@RequiredArgsConstructor
@Service
public class TasksServiceImpl implements TasksService {

    private final UsersRepository usersRepository;

    private final TasksRepository tasksRepository;

    @Override
    public TaskDto addTask(Long userId, NewTaskDto newTask) {

//        if (!usersRepository.existsById(userId)) {
//            throw new IncorrectUserIdException("User with id <" + userId + "> not found");
//        }

        User user = getUserOrThrow(userId);

        Task task = Task.builder()
                .description(newTask.getDescription())
                .title(newTask.getTitle())
                .startDate(LocalDate.parse(newTask.getStartDate()))
                .finishDate(LocalDate.parse(newTask.getFinishDate()))
                .executor(user)
                .build();

        tasksRepository.save(task);

        return from(task);
    }

    private User getUserOrThrow(Long userId) {
        return usersRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("User", userId));
    }
}
