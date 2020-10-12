package ru.test_rocket.my_test_task.controller;

import org.springframework.web.bind.annotation.*;
import ru.test_rocket.my_test_task.dto.SubdivisionResponseDto;
import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.SubdivisionDto;
import ru.test_rocket.my_test_task.service.SubdivisionService;
import ru.test_rocket.my_test_task.service.WorkerService;

import java.util.List;

@RestController
@RequestMapping(path = "/subdivision")
public class SubdivisionController {

    private final SubdivisionService subdivisionService;
    private final WorkerService workerService;

    public SubdivisionController(SubdivisionService subdivisionService, WorkerService workerService) {
        this.subdivisionService = subdivisionService;
        this.workerService = workerService;
    }

    @PostMapping(path = "/add")
    public void addSubdivision(@RequestBody SubdivisionDto subdivisionDto) {
        subdivisionService.addSubdivision(subdivisionDto);
    }

    @GetMapping(path = "/getAll")
    public List<SubdivisionResponseDto> findAllSubdivision() {
        return subdivisionService.findAllSubdivision();
    }

   /* @GetMapping(name = "/getWorkers")
    public List<WorkerResponseDto> getWorkerBySubdivisionId() {
        return subdivisionService.getWorkerBySubdivisionId(subdivisionService.get);
    }*/
}
