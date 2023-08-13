package de.ait.taskslist.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.ait.taskslist.dto.NewTaskDto;
import de.ait.taskslist.dto.NewTaskDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("TestsController is works: ")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
public class TasksIntegrationTest {

    private static final NewTaskDto NEW_TASK = NewTaskDto.builder()
            .description("Test Task")
            .title("Test Task")
            .startDate("2022-02-02")
            .finishDate("2023-03-02")
            .aboutUserId(1L)
            .build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Nested
    @DisplayName("POST /api/users/{user-id}/tasks is works: ")
    class AddTaskTest {

        @Test
        @Sql(scripts = "/sql/data_for_tasks.sql")
        @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
        public void add_task_for_exist_user() throws Exception {

            String body = objectMapper.writeValueAsString(NEW_TASK);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id", is(1)))
                    .andExpect(jsonPath("$.description", is("Test Task")))
                    .andExpect(jsonPath("$.title", is("Test Task")))
                    .andExpect(jsonPath("$.startDate", is("2022-02-02")))
                    .andExpect(jsonPath("$.finishDate", is("2022-03-02")))
                    .andExpect(jsonPath("$.about.id", is(1)))
                    .andExpect(jsonPath("$.about.email", is("test@mail.com")));
        }

        @Test
        public void add_task_for_not_exist_user() throws Exception {
            String body = objectMapper.writeValueAsString(NEW_TASK);

            mockMvc.perform(post("/api/tasks")
                            .header("Content-Type", "application/json")
                            .content(body))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}
