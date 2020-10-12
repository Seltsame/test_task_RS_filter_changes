package ru.test_rocket.my_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkerResponseDto {

    private Long id;
    private String workerName;
    private String subdivisionName;
    private LocalDate creationDate;

}
