package com.task.school.model;

import lombok.Builder;

import java.util.List;
@Builder
public record TaskResponseList(List<TaskResponse> list) {
}
