package com.task.school.model;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponse{
    private  String title;
    private String description;
    private LocalDateTime dueDate;
    private Boolean completed;

}
