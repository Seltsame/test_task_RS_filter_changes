package ru.test_rocket.my_test_task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.test_rocket.my_test_task.model.Worker;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingResponseDto {

    private Long meetingId;
    private String topic;
    private int workerQuantity;
    private LocalDateTime timeMeeting;
    private WorkerResponseDto accounterWorker;
    private String subdivisionName;

}
