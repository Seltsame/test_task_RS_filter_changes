package ru.test_rocket.my_test_task.repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.test_rocket.my_test_task.model.Worker;

import java.util.List;

@Repository
public interface WorkerRepository extends PagingAndSortingRepository<Worker, Long> {

    List<Worker> findAllBySubdivisionId(Long id);

    List<Worker> findAllByIdIn(List<Long> id);

    List<Worker> findAll();

}
