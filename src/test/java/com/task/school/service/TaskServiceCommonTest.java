package com.task.school.service;

import com.task.school.store.repository.TaskRepository;
import com.task.school.store.service.TaskService;
import lombok.AllArgsConstructor;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestConstructor;

@SpringBootTest
@AllArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class TaskServiceCommonTest {
    @MockBean
    TaskService taskService;

    @InjectMocks
    TaskRepository taskRepository;
}
