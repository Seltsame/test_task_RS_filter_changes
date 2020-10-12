package ru.test_rocket.my_test_task.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ru.test_rocket.my_test_task.dto.MeetingFilterDto;
import ru.test_rocket.my_test_task.dto.MeetingResponseDto;
import ru.test_rocket.my_test_task.dto.request.MeetingDto;
import ru.test_rocket.my_test_task.service.MeetingService;

@RestController
@RequestMapping(path = "/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping(path = "/add")
    public void addMeeting(@RequestBody MeetingDto meetingDto) {
        meetingService.addMeeting(meetingDto);
    }

    @PostMapping(path = "/getAll")
    public Page<MeetingResponseDto> getMeetings(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, MeetingFilterDto filterDto) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timeMeeting"));
        return meetingService.getMeetings(pageable, filterDto);
    }
}
