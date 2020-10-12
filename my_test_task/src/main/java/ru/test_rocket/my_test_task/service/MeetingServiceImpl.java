package ru.test_rocket.my_test_task.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.test_rocket.my_test_task.dto.MeetingFilterDto;
import ru.test_rocket.my_test_task.dto.MeetingResponseDto;
import ru.test_rocket.my_test_task.dto.request.MeetingDto;
import ru.test_rocket.my_test_task.model.Meeting;
import ru.test_rocket.my_test_task.repository.MeetingRepository;
import ru.test_rocket.my_test_task.repository.MeetingRepositoryCustom;
import ru.test_rocket.my_test_task.repository.SubdivisionRepository;
import ru.test_rocket.my_test_task.repository.WorkerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingServiceImpl implements MeetingService {

    private final WorkerRepository workerRepository;
    private final MeetingRepository meetingRepository;
    private final SubdivisionRepository subdivisionRepository;
    private final MeetingRepositoryCustom meetingRepositoryCustom;

    public MeetingServiceImpl(WorkerRepository workerRepository, MeetingRepository meetingRepository, SubdivisionRepository subdivisionRepository, MeetingRepositoryCustom meetingRepositoryCustom) {
        this.workerRepository = workerRepository;
        this.meetingRepository = meetingRepository;
        this.subdivisionRepository = subdivisionRepository;
        this.meetingRepositoryCustom = meetingRepositoryCustom;
    }


    @Override
    @Transactional
    public void addMeeting(MeetingDto meetingDto) {
        meetingRepository.save(getMeetingResponseDtoFromMeetingDto(meetingDto));
    }

    @Override
    @Transactional
    public Page<MeetingResponseDto> getMeetings(Pageable pageable, MeetingFilterDto filterDto) {
        if (filterDto == null) {
            return meetingRepository.findAll(pageable)
                    .map(this::getMeetingResponseDtoFromMeetingDto);
        }
        List<MeetingResponseDto> collect = meetingRepositoryCustom.getMeetingByFilter(filterDto).stream()
                .map((this::getMeetingResponseDtoFromMeetingDto)).collect(Collectors.toList());
        return new PageImpl<>(collect, pageable, collect.size());
    }


    private MeetingResponseDto getMeetingResponseDtoFromMeetingDto(Meeting meeting) {
        return MeetingResponseDto.builder()
                .topic(meeting.getTopic())
                .meetingId(meeting.getId())
                .subdivisionName(meeting.getSubdivision().getName())
                .timeMeeting(meeting.getTimeMeeting())
                .workerQuantity(meeting.getWorkerList().size())
                .accounterWorker(WorkerServiceImpl.getWorkerResponseDtoFromWorker(meeting.getWorkerOwner())).build();
    }

    private Meeting getMeetingResponseDtoFromMeetingDto(MeetingDto meetingDto) {
        return Meeting.builder()
                .workerOwner(workerRepository.findById(meetingDto.getAccounterWorkerId())
                        .orElseThrow(() -> new RuntimeException("Пользователя с таким id нету в бд")))
                .subdivision(subdivisionRepository.findById(meetingDto.getSubdivisionId()).orElseThrow())
                .timeMeeting(meetingDto.getMeetingDate())
                .topic(meetingDto.getTopic())
                .workerList(workerRepository.findAllByIdIn(meetingDto.getWorkerIdList()))
                .build();

    }

}
