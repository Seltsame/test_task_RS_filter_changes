package ru.test_rocket.my_test_task.service;

import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.WorkerDto;

import java.util.List;

public interface WorkerService {

    void addWorker(WorkerDto workerDto);

    List<WorkerResponseDto> getWorkersBySubdivisionId(Long id);

    List<WorkerResponseDto> findAllWorkers();
}
