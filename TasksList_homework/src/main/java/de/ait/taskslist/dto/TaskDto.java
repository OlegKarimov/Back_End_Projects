package de.ait.taskslist.dto;

import de.ait.taskslist.models.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Задача для какого-либо пользователя")
public class TaskDto {

    @Schema(description = "Идентификатор задачи", example = "1")
    private Long id;

    @Schema(description = "Текст задачи", example = "Текст для какого-либо пользователя...")
    private String description;

    @Schema(description = "Название задачи", example = "Название...")
    private String title;

    @Schema(description = "Дата начала выполнения задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "Дата окончания выполнения задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    @Schema(description = "Пользователь, для которого эта задача", example = "...")
    private UserInTaskDto executor;



    public static TaskDto from(Task task) {
        TaskDto result = TaskDto.builder()
                .id(task.getId())
                .description(task.getDescription())
                .title(task.getTitle())
                .build();

        if (task.getExecutor() != null) {
            result.setExecutor(UserInTaskDto.from(task.getExecutor()));
        }

        if (task.getStartDate() != null) {
            result.setStartDate(task.getStartDate().toString());
        }

        if (task.getFinishDate() != null) {
            result.setFinishDate(task.getFinishDate().toString());
        }

        return result;
    }

    public static List<TaskDto> from(List<Task> tasks) {
        return tasks.stream()
                .map(TaskDto::from)
                .collect(Collectors.toList());
    }
}
