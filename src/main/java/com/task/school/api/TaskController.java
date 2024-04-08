package com.task.school.api;

import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.utils.EndPoint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = EndPoint.tasks)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class TaskController {

    @GetMapping()
    public ResponseEntity<TaskResponse> getTasks() {
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse("1", "2", LocalDateTime.now(), false));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse("2", "3", LocalDateTime.now(), false));
    }

    @PostMapping()
    public ResponseEntity<TaskResponse> greatTask(TaskRequest taskRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse(taskRequest.title(), "2", LocalDateTime.now(), false));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> putTask(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse("2", "3", LocalDateTime.now(), false));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse("2", "3", LocalDateTime.now(), false));
    }
}
/*
 GET /tasks - Получить список всех задач.

GET /tasks/{id} [ задачи/{id}] - Получить информацию о задаче по её id.

POST /tasks - Создать новую задачу.

PUT /tasks/{id} - Обновить информацию о задаче.

DELETE /tasks/{id} - Удалить задачу.
 */