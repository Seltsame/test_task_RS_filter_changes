package ru.test_rocket.my_test_task.repository;

import ru.test_rocket.my_test_task.dto.MeetingFilterDto;
import ru.test_rocket.my_test_task.model.Meeting;

import java.util.List;

public interface MeetingRepositoryCustom {
    List<Meeting> getMeetingByFilter(MeetingFilterDto filterDto);
}
