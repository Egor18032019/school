package com.task.school.api.controller;

import com.task.school.api.Execution;
import com.task.school.exeption.BadRequestException;
import com.task.school.model.NewTaskResponse;
import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.model.TaskResponseList;
import com.task.school.store.service.TaskServiceCommon;
import com.task.school.utils.EndPoint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = EndPoint.tasks)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class TaskController implements Execution {
    TaskServiceCommon taskService;

    @GetMapping()
    public ResponseEntity<TaskResponseList> getTasks() {
        TaskResponseList result = taskService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> getTask(@PathVariable String id) {

        long idForBd;
        try {
            idForBd = Long.parseLong(id);
        } catch (RuntimeException exception) {
            throw new BadRequestException(id + " of the wrong format");
        }
        TaskResponse task = taskService.getTask(idForBd);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @PostMapping()
    public ResponseEntity<NewTaskResponse> greatTask(@RequestBody TaskRequest taskRequest) {
        Long id = taskService.save(taskRequest);
        return ResponseEntity.status(HttpStatus.OK).body(new NewTaskResponse(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> putTask(@PathVariable String id,
                                                @RequestBody TaskRequest taskRequest) {
        long idForBd;
        try {
            idForBd = Long.parseLong(id);
        } catch (RuntimeException exception) {
            throw new BadRequestException(id + " of the wrong format");
        }
        TaskResponse task = taskService.changeTask(idForBd, taskRequest);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TaskResponse> deleteTask(@PathVariable String id) {
        long idForBd;
        try {
            idForBd = Long.parseLong(id);
        } catch (RuntimeException exception) {
            throw new BadRequestException(id + " of the wrong format");
        }
        taskService.deleteById(idForBd);
        return ResponseEntity.status(HttpStatus.OK).body(new TaskResponse());
    }
}
