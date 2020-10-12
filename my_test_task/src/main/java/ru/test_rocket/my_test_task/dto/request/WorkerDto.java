package ru.test_rocket.my_test_task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {

    private String name;
    private Long subdivisionId;
    private LocalDate birthDayWorkerDate;
}
