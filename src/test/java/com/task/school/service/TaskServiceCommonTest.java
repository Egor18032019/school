package com.task.school.service;

import com.task.school.exeption.NotFoundException;
import com.task.school.model.TaskRequest;
import com.task.school.store.entity.Task;
import com.task.school.store.repository.TaskRepository;
import com.task.school.store.service.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TaskServiceCommonTest {
    @InjectMocks
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;


    @DisplayName("Get not found exception if not found Task")
    @Test
    public void serviceGetTaskNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> taskService.getTask(111L));
    }

    @DisplayName("Get not found exception if we want to change a non-existent Task")
    @Test
    public void serviceChangeTaskNotFoundException() {
        Assertions.assertThrows(NotFoundException.class, () -> taskService.changeTask(111l, new TaskRequest("t", "d", LocalDateTime.now(), false)));
    }


}
