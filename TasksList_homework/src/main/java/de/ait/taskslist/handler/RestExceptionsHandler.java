package de.ait.taskslist.handler;

import de.ait.taskslist.dto.ErrorDto;
import de.ait.taskslist.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
@ControllerAdvice
public class RestExceptionsHandler {

    @ExceptionHandler(RestException.class) // какой класс ошибок перехватываем
    public ResponseEntity<ErrorDto> handleRestException(RestException e) { // что именно перехватили
        return ResponseEntity // сформировали ответ
                .status(e.getHttpStatus()) // прописываем статус ответа
                .body(ErrorDto.builder() // собираем ответ
                        .message(e.getMessage())
                        .build());
    }
}
