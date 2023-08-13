package de.ait.taskslist.models;

/*
Task
- id
- String description
- String title
- LocalDate startDate
- LocalDate finishDate
- User executor - исполнитель задачи
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String title;
    private LocalDate startDate;
    private LocalDate finishDate;
    @ManyToOne
    @JoinColumn(name = "executor_id")
    private User executor;

}

