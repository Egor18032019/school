package com.task.school.model;

import lombok.Builder;

import java.time.LocalDateTime;
@Builder
public record TaskRequest (String title,
                          String description,
                          LocalDateTime dueDate,
                          Boolean completed) {

}

