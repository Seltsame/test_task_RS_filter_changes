package ru.test_rocket.my_test_task.service;

import org.springframework.stereotype.Service;
import ru.test_rocket.my_test_task.dto.SubdivisionResponseDto;
import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.SubdivisionDto;
import ru.test_rocket.my_test_task.model.Subdivision;
import ru.test_rocket.my_test_task.repository.SubdivisionRepository;
import ru.test_rocket.my_test_task.repository.WorkerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubdivisionServiceImpl implements SubdivisionService {

    private final SubdivisionRepository subdivisionRepository;
    private final WorkerRepository workerRepository;

    public SubdivisionServiceImpl(SubdivisionRepository subdivisionRepository, WorkerRepository workerRepository) {
        this.subdivisionRepository = subdivisionRepository;
        this.workerRepository = workerRepository;
    }


    @Override
    public void addSubdivision(SubdivisionDto subdivisionDto) {
        subdivisionRepository.save(getSubdivisionFromSubdivisionDto(subdivisionDto));
    }

    @Override
    @Transactional
    public List<WorkerResponseDto> getWorkerBySubdivisionId(Long id) {
        return workerRepository.findAllBySubdivisionId(id).stream()
                .map(worker -> WorkerServiceImpl.getWorkerResponseDtoFromWorker(worker))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<SubdivisionResponseDto> findAllSubdivision() {
        return subdivisionRepository.findAll().stream()
                .map(subdivision -> getSubdivisionResponseDtoFromSubdivision(subdivision))
                .collect(Collectors.toList());
    }


    private SubdivisionResponseDto getSubdivisionResponseDtoFromSubdivision(Subdivision subdivision) {
        return SubdivisionResponseDto.builder()
                .id(subdivision.getId())
                .subdivisionName(subdivision.getName())
                .workerQuantity(subdivision.getWorkerSet().size())
                .build();
    }

    private Subdivision getSubdivisionFromSubdivisionDto(SubdivisionDto subdivisionDto) {
        return Subdivision.builder()
                .name(subdivisionDto.getSubdivisionNameDto())
                .build();
    }
}
