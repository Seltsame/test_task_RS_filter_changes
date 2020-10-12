package ru.test_rocket.my_test_task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.test_rocket.my_test_task.dto.MeetingFilterDto;
import ru.test_rocket.my_test_task.dto.MeetingResponseDto;
import ru.test_rocket.my_test_task.dto.request.MeetingDto;


public interface MeetingService {

    void addMeeting(MeetingDto meetingDto);

    Page<MeetingResponseDto> getMeetings(Pageable pageable, MeetingFilterDto filterDto);
}
