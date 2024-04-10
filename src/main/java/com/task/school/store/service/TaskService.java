package com.task.school.store.service;

import com.task.school.exeption.BadRequestException;
import com.task.school.exeption.NotFoundException;
import com.task.school.model.TaskRequest;
import com.task.school.model.TaskResponse;
import com.task.school.model.TaskResponseList;
import com.task.school.store.entity.Task;
import com.task.school.store.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskService implements TaskServiceCommon {
    TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskResponseList getAllTasks() {
        List<Task> list = taskRepository.findAll();
        List<TaskResponse> tasks = new ArrayList<>();
        for (Task point : list) {
            tasks.add(new TaskResponse(point.getTitle(), point.getDescription(), point.getDueDate(), point.getCompleted()));
        }

        TaskResponseList taskResponseList = new TaskResponseList(tasks);
        return taskResponseList;
    }

    @Override
    public TaskResponse getTask(Long id) {
        Optional<Task> foo = taskRepository.findById(id);
        if (foo.isPresent()) {
            Task bar = foo.get();
            return new TaskResponse(bar.getTitle(), bar.getDescription(), bar.getDueDate(), bar.getCompleted());
        } else {
            throw new NotFoundException("Not found task with " + id);
        }
    }

    @Override
    public Long save(TaskRequest taskRequest) {
        Task task = new Task(taskRequest.getTitle(), taskRequest.getDescription(), taskRequest.getDueDate(), taskRequest.getCompleted());
        taskRepository.save(task);
        return task.id();
    }

    @Override
    public TaskResponse changeTask(long id, TaskRequest taskRequest) {
        Optional<Task> foo = taskRepository.findById(id);
        if (foo.isPresent()) {
            Task modified = foo.get();
            modified.setTitle(taskRequest.getTitle());
            modified.setDescription(taskRequest.getDescription());
            modified.setDueDate(taskRequest.getDueDate());
            modified.setCompleted(taskRequest.getCompleted());
            modified.setId(id);// явно указал
            taskRepository.save(modified);
        }else {
            throw new NotFoundException("Not found task with " + id);
        }

        return getTask(id);
    }

    @Override
    public void deleteById(long idForBd) {
        taskRepository.deleteById(idForBd);
    }
}
