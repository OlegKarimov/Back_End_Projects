package de.ait.taskslist.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "tasks")
@ToString(exclude = "tasks")
@Entity
@Table(name = "account")
public class User {

    public enum Role {
        ADMIN,
        USER,
        MANAGER
    }

    public enum State {
        NOT_CONFIRMED,
        CONFIRMED,
        BANNED,
        DELETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "executor")
    private List<Task> tasks;
}
