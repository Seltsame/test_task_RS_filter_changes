package ru.test_rocket.my_test_task.controller;

import org.springframework.web.bind.annotation.*;
import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.WorkerDto;
import ru.test_rocket.my_test_task.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping(path = "/worker")
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(path = "/add")
    public void addWorker(@RequestBody WorkerDto workerDto) {
        workerService.addWorker(workerDto);
    }

    @GetMapping(path = "/getAll")
    public List<WorkerResponseDto> getAllWorkers() {
        return workerService.findAllWorkers();
    }
}
