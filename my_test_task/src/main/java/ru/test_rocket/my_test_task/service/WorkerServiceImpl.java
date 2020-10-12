package ru.test_rocket.my_test_task.service;

import org.springframework.stereotype.Service;
import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.WorkerDto;
import ru.test_rocket.my_test_task.model.Worker;
import ru.test_rocket.my_test_task.repository.SubdivisionRepository;
import ru.test_rocket.my_test_task.repository.WorkerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository workerRepository;
    private final SubdivisionRepository subdivisionRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository, SubdivisionRepository subdivisionRepository) {
        this.workerRepository = workerRepository;
        this.subdivisionRepository = subdivisionRepository;
    }

    @Override
    public void addWorker(WorkerDto workerDto) {
        workerRepository.save(getWorkerFromWorkerDto(workerDto));
    }

    @Override
    @Transactional
    public List<WorkerResponseDto> getWorkersBySubdivisionId(Long id) {
        return workerRepository.findAllBySubdivisionId(id).stream()
                .map(worker -> getWorkerResponseDtoFromWorker(worker))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkerResponseDto> findAllWorkers() {
        return workerRepository.findAll().stream()
                .map(worker -> getWorkerResponseDtoFromWorker(worker))
                .collect(Collectors.toList());
    }


    private Worker getWorkerFromWorkerDto(WorkerDto workerDto) {
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setSubdivision(subdivisionRepository.findById(workerDto.getSubdivisionId())
                .orElseThrow(() -> new IllegalArgumentException(("Подразделение не найдено " + workerDto.getSubdivisionId()))));
        return worker;
    }

    public static WorkerResponseDto getWorkerResponseDtoFromWorker(Worker worker) {
        return WorkerResponseDto.builder()
                .id(worker.getId())
                .workerName(worker.getName())
                .creationDate(worker.getBirthDay())
                .subdivisionName(worker.getSubdivision().getName())
                .build();
    }
}




