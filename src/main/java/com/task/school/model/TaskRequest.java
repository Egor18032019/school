package com.task.school.model;

import lombok.*;

import java.time.LocalDateTime;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Boolean completed;
}

