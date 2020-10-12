package ru.test_rocket.my_test_task.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingDto {
    private String topic;
    private LocalDateTime meetingDate;
    private Long subdivisionId;
    private List<Long> workerIdList;
    private Long accounterWorkerId;
}
