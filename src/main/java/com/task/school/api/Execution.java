package com.task.school.api;

import com.task.school.model.NewTaskResponse;
import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.model.TaskResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface Execution {
    /**
     * Получить список всех задач.
     *
     * @return TaskResponseList
     */
    @GetMapping()
    ResponseEntity<TaskResponseList> getTasks();

    /**
     * Получить информацию о задаче по её id.
     *
     * @return TaskResponse
     */
    @GetMapping("/{id}")
    ResponseEntity<TaskResponse> getTask(String id);

    /**
     * Создать новую задачу
     *
     * @return NewTaskResponse(id нового элемента)
     */
    @PostMapping()
    ResponseEntity<NewTaskResponse> greatTask(TaskRequest taskRequest);

    /**
     * Обновить информацию о задаче.
     *
     * @return TaskResponse
     */
    @PutMapping("/{id}")
    ResponseEntity<TaskResponse> putTask(String id, TaskRequest taskRequest);

    /**
     * Удалить задачу.
     *
     * @return TaskResponse
     */
    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteTask(String id);

}
