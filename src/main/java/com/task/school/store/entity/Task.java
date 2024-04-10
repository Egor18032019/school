package com.task.school.store.entity;

import com.task.school.store.entity.base.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;


@Builder
@Entity
@Table(name = "tasks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AbstractBaseEntity {
    @Column()
    private String title;
    @Column()
    private String description;
    @Column()
    private LocalDateTime dueDate;
    @Column()
    private Boolean completed;
}
