package com.task.school.store.service;

import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.model.TaskResponseList;

public interface TaskServiceCommon {
    TaskResponseList getAllTasks();

    TaskResponse getTask(Long id);

    Long save(TaskRequest taskRequest);

    TaskResponse changeTask(long idForBd, TaskRequest taskRequest);

    void deleteById(long idForBd);
}
