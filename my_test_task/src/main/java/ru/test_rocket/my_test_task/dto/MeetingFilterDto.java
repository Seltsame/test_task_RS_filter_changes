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
public class MeetingFilterDto {
    String topic;
    LocalDate startDate;
    LocalDate endDate;
    Long workerId;
    Long subdivisionId;
}
