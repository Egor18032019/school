package com.task.school.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.task.school.api.controllers.TaskController;
import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.model.TaskResponseList;
import com.task.school.store.service.TaskService;
import com.task.school.utils.EndPoint;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    TaskService taskService;

    @Test
    void getTask() throws Exception {
        long idForBd = 80000;
        TaskResponse task = new TaskResponse("t", "d", LocalDateTime.now(), true);
        Mockito.when(this.taskService.getTask(idForBd)).thenReturn(task);
        mockMvc.perform(MockMvcRequestBuilders.get(EndPoint.tasks + "/" + idForBd))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void getTasks() throws Exception {
        TaskResponse task = new TaskResponse("getTasks", "getTasks", LocalDateTime.now(), true);
        List<TaskResponse> list = new ArrayList<>();
        list.add(task);
        TaskResponseList result = new TaskResponseList(list);
        Mockito.when(this.taskService.getAllTasks()).thenReturn(result);
        mockMvc.perform(MockMvcRequestBuilders.get(EndPoint.tasks))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void greatTask() throws Exception {
        TaskRequest task = new TaskRequest("gt", "greatTask", LocalDateTime.now(), true);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Mockito.when(this.taskService.save(task)).thenReturn(1L);
        mockMvc.perform(
                        MockMvcRequestBuilders.post(EndPoint.tasks)
                                .content(objectMapper.writeValueAsString(task))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void putTask() throws Exception {
        TaskRequest request = new TaskRequest("gt", "greatTask", LocalDateTime.now(), true);
        TaskResponse response = new TaskResponse("gt", "greatTask", LocalDateTime.now(), true);
        ObjectMapper objectMapper = new ObjectMapper();
        long idForBd = 80000;
        objectMapper.registerModule(new JavaTimeModule());
        Mockito.when(this.taskService.changeTask(idForBd, request)).thenReturn(response);
        mockMvc.perform(
                        MockMvcRequestBuilders.put(EndPoint.tasks + "/" + idForBd)
                                .content(objectMapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void deleteTask() throws Exception {
        long idForBd = 100000;
        doNothing().when(taskService).deleteById(idForBd);
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(EndPoint.tasks + "/" + idForBd)
                )
                .andExpect(status().isOk())
                .andReturn();
    }
}
