package de.ait.taskslist.repositories;

import de.ait.taskslist.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public interface UsersRepository extends JpaRepository<User, Long> {
}
