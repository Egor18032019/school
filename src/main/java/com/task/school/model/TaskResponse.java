package com.task.school.model;

import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record TaskResponse(String title,
                           String description,
                           LocalDateTime dueDate,
                           Boolean completed) {

}
