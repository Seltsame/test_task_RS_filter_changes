package ru.test_rocket.my_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubdivisionResponseDto {

    private Long id;
    private String subdivisionName;
    private int workerQuantity;
}
