package de.ait.taskslist.repositories;

import de.ait.taskslist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Task, Long> {
    //    List<Task> findAllByDate(Integer year, Integer month, Integer day);
}
