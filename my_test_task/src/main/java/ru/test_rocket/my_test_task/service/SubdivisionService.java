package ru.test_rocket.my_test_task.service;

import ru.test_rocket.my_test_task.dto.SubdivisionResponseDto;
import ru.test_rocket.my_test_task.dto.WorkerResponseDto;
import ru.test_rocket.my_test_task.dto.request.SubdivisionDto;

import java.util.List;


public interface SubdivisionService {

    void addSubdivision(SubdivisionDto subdivisionDto);

    List<WorkerResponseDto> getWorkerBySubdivisionId(Long id);

    List<SubdivisionResponseDto> findAllSubdivision();



}
